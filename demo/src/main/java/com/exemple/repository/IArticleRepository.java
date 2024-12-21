package com.exemple.repository;

import com.exemple.entity.Article;

import java.util.List;

public interface IArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAll();
}
