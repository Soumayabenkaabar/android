package com.appfood.shoescenter;

public class Produit {

    private int imageResId;
    private String nom;
    private double prix;
    private String taille;
    private String couleur;
    private int quantite;

    // Constructeur
    public Produit(int imageResId, String nom, double prix, String taille, String couleur, int quantite) {
        this.imageResId = imageResId;
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
        this.couleur = couleur;
        this.quantite = quantite;
    }

    // Getters et setters
    public int getImageResId() {
        return imageResId;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public String getTaille() {
        return taille;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
