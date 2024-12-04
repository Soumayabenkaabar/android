package com.appfood.shoescenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.appfood.shoescenter.CustomAdapter;

public class Catalogue extends AppCompatActivity {
    GridView gridView;
    String[] categories = {"Homme", "Femme", "Enfant", "Sport"};
    int[] images = {R.drawable.homme, R.drawable.femme, R.drawable.enfant, R.drawable.sport};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        gridView = findViewById(R.id.gridView);
        CustomAdapter adapter = new CustomAdapter(this, categories, images);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0: // Homme
                        intent = new Intent(Catalogue.this, Homme.class);
                        startActivity(intent);
                        break;
                    case 1: // Femme
                        intent = new Intent(Catalogue.this, Femme.class);
                        startActivity(intent);
                        break;
                    case 2: // Enfant
                        intent = new Intent(Catalogue.this, Enfant.class);
                        startActivity(intent);
                        break;
                    case 3: // Sport
                        intent = new Intent(Catalogue.this, Sport.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_panier) {
            // Action à réaliser lorsque l'élément Panier est sélectionné
            // Par exemple, ouvrir l'activité Panier
            Intent intent = new Intent(Catalogue.this, PanierActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.Accueil)
        {  Intent intent = new Intent(Catalogue.this, Accueil.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Catalogue)
        {  Intent intent = new Intent(Catalogue.this, Catalogue.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Commande)
        {  Intent intent = new Intent(Catalogue.this, Commande.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Contact)
        {  Intent intent = new Intent(Catalogue.this, Contact.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Homme)
        {  Intent intent = new Intent(Catalogue.this, Homme.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Enfant)
        {  Intent intent = new Intent(Catalogue.this, Enfant.class);
            startActivity(intent);
            return true;}
        else if (id == R.id.Femme)
        {  Intent intent = new Intent(Catalogue.this, Femme.class);
            startActivity(intent);
            return true;}

        else if (id == R.id.Sport)
        {  Intent intent = new Intent(Catalogue.this, Sport.class);
            startActivity(intent);
            return true;}


        return super.onOptionsItemSelected(item);
    }
}