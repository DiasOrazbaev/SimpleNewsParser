package kz.fastjava.newsparser.cron;

import kz.fastjava.newsparser.model.News;
import kz.fastjava.newsparser.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Parser {
    private final NewsService newsService;

    public Parser(NewsService newsService) {
        this.newsService = newsService;
    }

    @Scheduled(fixedDelay = 60000)
    public void parseNewNews() throws IOException {
        String URL = "https://news.ycombinator.com/";
        Document doc = Jsoup.connect(URL).
                userAgent("Mozzila").
                timeout(5000).
                referrer("https://google.com").
                get();
        Elements news = doc.getElementsByClass("titlelink");
        news.forEach(x -> newsService.save(new News(x.ownText())));
    }
}
