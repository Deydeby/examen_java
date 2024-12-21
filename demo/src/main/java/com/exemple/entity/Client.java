package com.exemple.entity;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String ville;
    private String quartier;
    private String numeroVilla;
    private String telephone;

    // Constructeur par défaut
    public Client() {}

    // Constructeur avec paramètres
    public Client(String nom, String prenom, String ville, String quartier, String numeroVilla, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.quartier = quartier;
        this.numeroVilla = numeroVilla;
        this.telephone = telephone;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getNumeroVilla() {
        return numeroVilla;
    }

    public void setNumeroVilla(String numeroVilla) {
        this.numeroVilla = numeroVilla;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
