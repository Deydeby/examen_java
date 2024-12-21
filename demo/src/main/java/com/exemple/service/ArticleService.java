package com.exemple.service;

import com.exemple.entity.Article;
import com.exemple.repository.IArticleRepository;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private IArticleRepository articleRepository;

    public List<Article> listerArticlesDisponibles() {
        return articleRepository.findAll();
    }
}
