package com.exemple.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @ManyToOne
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Article> articles;

    public Commande() {}

    public Commande(String date, Client client, List<Article> articles) {
        this.date = date;
        this.client = client;
        this.articles = articles;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
