package com.appfood.shoescenter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        setupCardListeners();
    }
    private void setupCardListeners() {
        // Facebook
        CardView facebookButton = findViewById(R.id.f);
        facebookButton.setOnClickListener(v -> openUrl("https://www.facebook.com/groups/402531499098212"));

        // Instagram
        CardView instagramButton = findViewById(R.id.i);
        instagramButton.setOnClickListener(v -> openUrl("https://www.instagram.com/shoescenter_officiel/"));

        // Gmail
        CardView gmailButton = findViewById(R.id.g);
        gmailButton.setOnClickListener(v -> sendEmail("shoescentergabes@example.com", "Contact Request"));

        // Phone
        CardView phoneButton = findViewById(R.id.a);
        phoneButton.setOnClickListener(v -> makePhoneCall("+123456789"));
    }

    private void openUrl(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                showToast("Aucune application pour ouvrir ce lien.");
            }
        } catch (Exception e) {
            showToast("Erreur lors de l'ouverture du lien.");
        }
    }

    private void sendEmail(String email, String subject) {
        try {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + email));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(emailIntent, "Envoyer un e-mail"));
            } else {
                showToast("Aucune application d'e-mail disponible.");
            }
        } catch (Exception e) {
            showToast("Erreur lors de l'envoi de l'e-mail.");
        }
    }

    private void makePhoneCall(String phoneNumber) {
        try {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
            phoneIntent.setData(Uri.parse("tel:" + phoneNumber));
            if (phoneIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(phoneIntent);
            } else {
                showToast("Aucune application pour effectuer un appel.");
            }
        } catch (Exception e) {
            showToast("Erreur lors de l'appel.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // Assurez-vous que votre fichier `menu.xml` existe
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;

        if (item.getItemId() == R.id.menu_panier) {
            intent = new Intent(Contact.this, PanierActivity.class);
        } else if (item.getItemId() == R.id.Accueil) {
            intent = new Intent(Contact.this, Accueil.class);
        } else if (item.getItemId() == R.id.Catalogue) {
            intent = new Intent(Contact.this, Catalogue.class);
        } else if (item.getItemId() == R.id.Commande) {
            intent = new Intent(Contact.this, Commande.class);
        } else if (item.getItemId() == R.id.Contact) {
            intent = new Intent(Contact.this, Contact.class);
        } else if (item.getItemId() == R.id.Enfant) {
            intent = new Intent(Contact.this, Enfant.class);
        } else if (item.getItemId() == R.id.Femme) {
            intent = new Intent(Contact.this, Femme.class);
        } else if (item.getItemId() == R.id.Sport) {
            intent = new Intent(Contact.this, Sport.class);
        } else if (item.getItemId() == R.id.Homme) {
            intent = new Intent(Contact.this, Homme.class);
        }

        if (intent != null) {
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}