package com.exemple.repository;

import com.exemple.entity.Commande;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.exemple.utils.HibernateUtil;

public class CommandeRepository {

    private EntityManager entityManager;

    public CommandeRepository() {
        entityManager = (EntityManager) HibernateUtil.getEntityManagerFactory();
    }

    // Méthode pour enregistrer une commande
    public void save(Commande commande) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(commande);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Méthode pour rechercher une commande par son ID
    public Commande findById(Long id) {
        return entityManager.find(Commande.class, id);
    }

    // Méthode pour mettre à jour une commande
    public void update(Commande commande) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(commande);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer une commande
    public void delete(Long id) {
        Commande commande = findById(id);
        if (commande != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.remove(commande);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
