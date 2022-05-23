package com.example.smartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class GoogleMap extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = new SupportMapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
        MarkerOptions marker = new MarkerOptions().position(new LatLng(54.980781, 82.807407))
                .title("улица Титова, 242/1").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker3));


        googleMap.addMarker(marker);

        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(54.762883, 83.105945))
                .title("Комсомольская улица, 29").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker3));

        googleMap.addMarker(marker2);

        googleMap.setOnMarkerClickListener(new com.google.android.gms.maps.GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                switch (marker.getTitle())
                {
                    case "улица Титова, 242/1":
                        Intent i = new Intent(getApplicationContext(), info.class);
                        startActivity(i);
                        break;
                    case "Комсомольская улица, 29":
                        Intent a = new Intent(getApplicationContext(), info.class);
                        startActivity(a);
                        break;
                }


                return false;
            }
        });
    }

}