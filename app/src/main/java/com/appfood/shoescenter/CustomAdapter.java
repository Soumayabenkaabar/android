package com.appfood.shoescenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] categories;
    private int[] images;

    public CustomAdapter(Context context, String[] categories, int[] images) {
        this.context = context;
        this.categories = categories;
        this.images = images;
    }

    @Override
    public int getCount() {
        return categories.length; // Nombre d'éléments à afficher
    }

    @Override
    public Object getItem(int position) {
        return categories[position]; // Retourne l'élément à la position donnée
    }

    @Override
    public long getItemId(int position) {
        return position; // Retourne l'ID de l'élément à la position donnée
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Créez ou recyclez une vue pour afficher chaque élément
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false); // Assurez-vous d'avoir un layout pour chaque élément
        }

        // Configurez la vue avec les données
        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.grid_text);
        imageView.setImageResource(images[position]);
        textView.setText(categories[position]);

        return convertView; // Retourne la vue configurée
    }
}
