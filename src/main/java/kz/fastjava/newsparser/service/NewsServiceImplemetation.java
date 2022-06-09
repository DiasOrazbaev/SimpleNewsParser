package kz.fastjava.newsparser.service;

import kz.fastjava.newsparser.model.News;
import kz.fastjava.newsparser.repository.NewsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsServiceImplemetation implements NewsService{

    private final NewsRepository repository;

    @Override
    public void save(News news) {
        if (!isExist(news.getTitle()))
            repository.save(news);
    }

    @Override
    public boolean isExist(String title) {
        return getAllNews().stream().anyMatch(news -> title.equals(news.getTitle()));
    }

    @Override
    public List<News> getAllNews() {
        return repository.findAll();
    }
}
