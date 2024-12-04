package com.appfood.shoescenter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Enfant extends AppCompatActivity {


    private GridView gridViewProduits;
    private List<Produit> produits;

    // Déclarer la liste du panier
    private static List<Produit> panier = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfant);

        ListView listViewProduits = findViewById(R.id.listViewProduits);
        produits = new ArrayList<>();

        // Ajouter vos produits ici
        produits.add(new Produit(R.drawable.e1, "Chaussure 1", 49.99, "42", "Noir",1));
        produits.add(new Produit(R.drawable.e2, "Chaussure 2", 59.99, "43", "Bleu",1));
        produits.add(new Produit(R.drawable.e3, "Chaussure 3", 39.99, "41", "Rouge",1));
        produits.add(new Produit(R.drawable.e4, "Chaussure 1", 49.99, "42", "Noir",1));
        produits.add(new Produit(R.drawable.e5, "Chaussure 2", 59.99, "43", "Bleu",1));
        produits.add(new Produit(R.drawable.e6, "Chaussure 3", 39.99, "41", "Rouge",1));

        // Créer et définir l'adaptateur pour afficher les produits
        ProduitAdapter adapter = new ProduitAdapter(this, produits);
        listViewProduits.setAdapter(adapter);

        // Gérer les clics sur les éléments de la grille
        listViewProduits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Afficher la boîte de dialogue de confirmation pour ajouter au panier
                afficherBoiteDialogue(produits.get(position));
            }
        });
    }

    // Afficher la boîte de dialogue pour ajouter un produit au panier
    private void afficherBoiteDialogue(final Produit produit) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(produit.getNom());
        builder.setMessage("Pointure: " + produit.getTaille() + "\nCouleur: " + produit.getCouleur() + "\nPrix: " + String.format("%.2f €", produit.getPrix()));

        // Ajouter un bouton pour ajouter au panier
        builder.setPositiveButton("Ajouter au Panier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Ajouter le produit au panier
                panier.add(produit);

                // Afficher un Toast de confirmation
                Toast.makeText(Enfant.this, produit.getNom() + " ajouté au panier", Toast.LENGTH_SHORT).show();
            }
        });

        // Ajouter un bouton pour annuler
        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    // Passer au panier lorsque l'utilisateur clique sur le menu Panier
    public static List<Produit> getPanier() {
        return panier;
    }

    // Gérer les options du menu (par exemple, passer au panier)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_panier) {
            Intent intent = new Intent(Enfant.this, PanierActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.Accueil)
        {  Intent intent = new Intent(Enfant.this, Accueil.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Catalogue)
        {  Intent intent = new Intent(Enfant.this, Catalogue.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Commande)
        {  Intent intent = new Intent(Enfant.this, Commande.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Contact)
        {  Intent intent = new Intent(Enfant.this, Contact.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Enfant)
        {  Intent intent = new Intent(Enfant.this, Enfant.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Femme)
        {  Intent intent = new Intent(Enfant.this, Femme.class);
            startActivity(intent);
            return true;}

        else if (id == R.id.Sport)
        {  Intent intent = new Intent(Enfant.this, Sport.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Homme)
        {  Intent intent = new Intent(Enfant.this, Homme.class);
            startActivity(intent);
            return true;}


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // Assurez-vous que c'est le bon fichier
        return true;
    }

}
