package com.appfood.shoescenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // D'abord, définir la vue associée à cette activité
        setContentView(R.layout.activity_accueil);

        // Ensuite, récupérer les références des boutons
        Button btncat = findViewById(R.id.btnCat);
        Button btncontact = findViewById(R.id.btnContact);

        // Ajouter les écouteurs pour les boutons
        btncat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, Catalogue.class);
                startActivity(intent);
            }
        });

        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, Contact.class);
                startActivity(intent);
            }
        });
    }
}
