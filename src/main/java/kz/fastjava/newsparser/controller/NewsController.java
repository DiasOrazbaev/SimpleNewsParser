package kz.fastjava.newsparser.controller;

import kz.fastjava.newsparser.model.News;
import kz.fastjava.newsparser.service.NewsServiceImplemetation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/news")
public class NewsController {


    @Autowired
    private NewsServiceImplemetation newsService;

    @GetMapping
    @ResponseBody
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
