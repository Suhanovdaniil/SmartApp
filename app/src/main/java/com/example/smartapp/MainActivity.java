package com.example.smartapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<String[]> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        activityResultLauncher =
                registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<java.util.Map<String, Boolean>>() {
                    @Override
                    public void onActivityResult(java.util.Map<String, Boolean> result) {

                    }
                });


        Button bt = findViewById(R.id.connectbt);
        bt.setOnClickListener((View.OnClickListener) view -> {
            Intent i = new Intent(MainActivity.this, Connect.class);
            startActivity(i);
        });

        Button map = findViewById(R.id.mapbt);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPermissionGranted()) {
                    Intent b = new Intent(MainActivity.this, GoogleMap.class);
                    startActivity(b);
                }else{
                    getPermission();
                }
            }
        });

        Button st = findViewById(R.id.setingbt);
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(MainActivity.this, Seting.class);
                startActivity(c);
            }
        });


    }

    private void getPermission() {
        activityResultLauncher.launch(
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION} );
    }

    private boolean isPermissionGranted() {

        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
    }
}


