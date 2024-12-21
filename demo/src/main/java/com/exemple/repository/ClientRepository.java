package com.exemple.repository;

import com.exemple.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import com.exemple.utils.HibernateUtil;

public class ClientRepository {

    private EntityManager entityManager;

    public ClientRepository() {
        entityManager = (EntityManager) HibernateUtil.getEntityManagerFactory();
    }

    // Méthode pour enregistrer un client
    public void save(Client client) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(client);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Méthode pour rechercher un client par son ID
    public Client findById(Long id) {
        return entityManager.find(Client.class, id);
    }

    // Méthode pour rechercher un client par son téléphone
    public Client findByTelephone(String telephone) {
        return entityManager.createQuery("SELECT c FROM Client c WHERE c.telephone = :telephone", Client.class)
                            .setParameter("telephone", telephone)
                            .getSingleResult();
    }

    // Méthode pour mettre à jour un client
    public void update(Client client) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(client);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un client
    public void delete(Long id) {
        Client client = findById(id);
        if (client != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.remove(client);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
