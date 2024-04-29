package com.example.utsmobileprogramming;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity1 extends AppCompatActivity {

    Toolbar toolbar;
    EditText editTextTextMultiLine, editTextDate, editTextText, editTextTime, editTextPhone3, quantity;
    RadioButton radioButtonCookies, radioButtonCake, radioButtonCatering, radioButtonCuisine, radioButtonOthers;
    TextView orderTypeText;
    Button button;

    // SharedPreferences
    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Order by Request");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        editTextDate = findViewById(R.id.editTextDate);
        editTextText = findViewById(R.id.editTextText);
        editTextTime = findViewById(R.id.editTextTime);
        editTextPhone3 = findViewById(R.id.editTextPhone3);
        quantity = findViewById(R.id.quantity);
        radioButtonCookies = findViewById(R.id.radioButtonCookies);
        radioButtonCake = findViewById(R.id.radioButtonCake);
        radioButtonCatering = findViewById(R.id.radioButtonCatering);
        radioButtonCuisine = findViewById(R.id.radioButtonCuisine);
        radioButtonOthers = findViewById(R.id.radioButtonOthers);
        orderTypeText = findViewById(R.id.orderTypeText);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simpan name dan phone number ke SharedPreferences
                saveData(editTextText.getText().toString(), editTextPhone3.getText().toString());
                sent();
            }
        });

        // Ambil name dan phone number dari SharedPreferences
        String name = sharedPreferences.getString(KEY_NAME, "");
        String phone = sharedPreferences.getString(KEY_PHONE, "");
        editTextText.setText(name);
        editTextPhone3.setText(phone);
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

    // Metode untuk menampilkan dialog
    void sent() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView messageTextView = new TextView(this);

        // Memeriksa apakah radio button Cookies dipilih
        if (radioButtonCookies.isChecked()) {
            messageTextView.setText("Your Order: Cookies");
        }
        // Memeriksa apakah radio button Cake dipilih
        else if (radioButtonCake.isChecked()) {
            messageTextView.setText("Your Order: Cake");
        }
        // Memeriksa apakah radio button Catering dipilih
        else if (radioButtonCatering.isChecked()) {
            messageTextView.setText("Your Order: Catering");
        }
        // Memeriksa apakah radio button Cuisine dipilih
        else if (radioButtonCuisine.isChecked()) {
            messageTextView.setText("Your Order: Cuisine");
        }
        // Memeriksa apakah radio button Others dipilih
        else if (radioButtonOthers.isChecked()) {
            messageTextView.setText("Your Order: Others");
        }
        // Jika tidak ada radio button yang dipilih
        else {
            messageTextView.setText("Please select an order type!");
        }

        messageTextView.setTextColor(getResources().getColor(R.color.black));
        messageTextView.setTextSize(25);
        messageTextView.setPadding(95, 100, 0, 100);

        builder.setView(messageTextView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // Metode untuk menyimpan name dan phone number ke SharedPreferences
    private void saveData(String name, String phone) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_PHONE, phone);
        editor.apply();
    }
}
