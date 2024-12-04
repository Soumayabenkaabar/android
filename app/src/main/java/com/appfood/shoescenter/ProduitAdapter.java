package com.appfood.shoescenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProduitAdapter extends BaseAdapter {
    private Context context;
    private List<Produit> produits;

    // Constructeur de l'adaptateur
    public ProduitAdapter(Context context, List<Produit> produits) {
        this.context = context;
        this.produits = produits;
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Si la vue est null, on crée une nouvelle vue
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_produit, parent, false);
        }

        // Récupérer le produit à la position donnée
        Produit produit = produits.get(position);

        // Récupérer les éléments du layout
        ImageView imgProduit = convertView.findViewById(R.id.imgProduit);
        TextView nomProduit = convertView.findViewById(R.id.nomProduit);
        TextView txtPrix = convertView.findViewById(R.id.txtPrix);

        // Remplir les informations du produit dans la vue
        imgProduit.setImageResource(produit.getImageResId());  // Utilisez l'ID de l'image
        nomProduit.setText(produit.getNom());                   // Utilisez le nom du produit
        txtPrix.setText(String.format("%.2f €", produit.getPrix())); // Affichez le prix avec 2 décimales

        return convertView;
    }
}
