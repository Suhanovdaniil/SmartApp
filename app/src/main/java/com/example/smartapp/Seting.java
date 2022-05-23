package com.example.smartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Seting extends AppCompatActivity {

    private Button language_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seting);

        language_btn = findViewById(R.id.btn_language);
        language_btn.setOnClickListener((View.OnClickListener) view -> {
            Toast.makeText(this, "Смена языков находится в разработке!", Toast.LENGTH_SHORT).show();
        });
    }
}
