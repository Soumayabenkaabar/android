package com.appfood.shoescenter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PanierActivity extends AppCompatActivity {

    private ListView listView;  // Liste des produits du panier
    private TextView textViewTotal;  // Affiche le total du panier
    private List<Produit> panier;  // Liste des produits dans le panier

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);  // Assurez-vous que le bon layout est utilisé

        listView = findViewById(R.id.listViewPanier);  // Associez la ListView à la vue
        textViewTotal = findViewById(R.id.textViewTotal);  // Associez le TextView au total

        panier = new ArrayList<>();  // Initialisez la liste du panier




        // Créez et définissez l'adaptateur
        ProduitAdapter adapter = new ProduitAdapter(this, panier);  // Utilisez l'adaptateur pour afficher les produits
        listView.setAdapter(adapter);  // Appliquez l'adaptateur à la ListView

        // Mettez à jour le total du panier
        updateTotal();  // Appelez une méthode pour mettre à jour le total affiché

        // Gestion du clic sur le bouton "Passer commande"
        Button buttonPasserCommande = findViewById(R.id.buttonPasserCommande);
        buttonPasserCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez ici la logique pour passer la commande
            }
        });
    }

    // Méthode pour calculer et mettre à jour le total du panier
    private void updateTotal() {
        double total = 0.0;
        for (Produit produit : panier) {
            total += produit.getPrix();  // Ajoutez le prix de chaque produit
        }
        textViewTotal.setText("Total: " + String.format("%.2f €", total));  // Mettez à jour l'affichage du total
    }
}
