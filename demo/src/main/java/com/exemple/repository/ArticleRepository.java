package com.exemple.repository;

import com.exemple.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.exemple.utils.HibernateUtil;

public class ArticleRepository {

    private EntityManager entityManager;

    public ArticleRepository() {
        entityManager = (EntityManager) HibernateUtil.getEntityManagerFactory();
    }

    // Méthode pour enregistrer un article
    public void save(Article article) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(article);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Méthode pour rechercher un article par son ID
    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    // Méthode pour mettre à jour un article
    public void update(Article article) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(article);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un article
    public void delete(Long id) {
        Article article = findById(id);
        if (article != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.remove(article);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
