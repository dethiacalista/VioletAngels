// Nama : Dethia Calista Fakhirah
// NIM  : 59220067
// Mata Kuliah    : Mobile Programming
// Dosen Pengajar : Fikri Fadlillah, ST., MMSI
// File : DetailActivity.java

package com.example.utsmobileprogramming;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Cookies Catalog");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView productImage = findViewById(R.id.productImage);
        TextView productName = findViewById(R.id.productName);
        TextView productDescription = findViewById(R.id.productDescription);

        // Set data for product 0
        productImage.setImageResource(R.drawable.cadbury);
        productName.setText("Cadbury Cookies");
        productDescription.setText("Satisfy your sweet cravings with our heavenly Vanilla Cookies, each adorned with luxurious Cadbury Chocolate!");

        ImageView productImage1 = findViewById(R.id.productImage1);
        TextView productName1 = findViewById(R.id.productName1);
        TextView productDescription1 = findViewById(R.id.productDescription1);

        // Set data for product 1
        productImage1.setImageResource(R.drawable.nutella);
        productName1.setText("Nutella Cookies");
        productDescription1.setText("Treat yourself to a moment of pure bliss with our Vanilla Cookies generously layered with delectable Nutella Spread!");

        ImageView productImage2 = findViewById(R.id.productImage2);
        TextView productName2 = findViewById(R.id.productName2);
        TextView productDescription2 = findViewById(R.id.productDescription2);

        // Set data for product 2
        productImage2.setImageResource(R.drawable.kenari);
        productName2.setText("Walnut Cookies");
        productDescription2.setText("Embark on a journey of taste with our Chocolate Cookies lavishly topped with crunchy walnuts!");

        ImageView productImage3 = findViewById(R.id.productImage3);
        TextView productName3 = findViewById(R.id.productName3);
        TextView productDescription3 = findViewById(R.id.productDescription3);

        // Set data for product 3
        productImage3.setImageResource(R.drawable.kacang);
        productName3.setText("Mixed Nuts Cookies");
        productDescription3.setText("Discover pure delight in every bite with our Vanilla Cookies infused with a delightful blend of assorted nuts!");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle toolbar item clicks
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Kembali ke MainActivity saat tombol back di toolbar ditekan
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
