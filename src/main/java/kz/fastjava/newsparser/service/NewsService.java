package kz.fastjava.newsparser.service;

import kz.fastjava.newsparser.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    void save(News news);
    boolean isExist(String title);
    List<News> getAllNews();
}
