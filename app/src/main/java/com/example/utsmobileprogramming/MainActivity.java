// Nama : Dethia Calista Fakhirah
// NIM  : 59220067
// Mata Kuliah    : Mobile Programming
// Dosen Pengajar : Fikri Fadlillah, ST., MMSI
// File : MainActivity.java

package com.example.utsmobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button cookiesButton, cakeButton, otherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cookiesButton = findViewById(R.id.cookiesButton);
        otherButton = findViewById(R.id.otherButton);

        cookiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke DetailActivity
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });

        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke DetailActivity1
                startActivity(new Intent(MainActivity.this, DetailActivity1.class));
            }
        });
    }
}
