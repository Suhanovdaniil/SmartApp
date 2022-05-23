package com.example.smartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class info extends AppCompatActivity {

    String [] names = {"Сизый голубь", "Домовый воробей", "Полевой воробей", "Черный стриж", "Белопоясный стриж", "Сорока", "Серая ворона", "Грач", "Галка", "Коршун", "Серебристая чайка", "Озерная чайка", "Рябинник", "Большая синица", "Белая трясогузка", "Садовая горихвостка", "Скворец", "Кряква", "Городская ласточка", "Иволга"};
    int [] photo_res = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12, R.drawable.b13, R.drawable.b14, R.drawable.b15, R.drawable.b16, R.drawable.b17, R.drawable.b18, R.drawable.b19, R.drawable.b20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        BirdsAdapter adapter = new BirdsAdapter(this, makeBirds());
        ListView lv = (ListView) findViewById(R.id.myList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name =  ((Birds)parent.getItemAtPosition(position)).name;
                String url = "https://www.google.ru/search?q=" + name.replace(" ", "+");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        lv.setAdapter(adapter);
    }
    Birds[] makeBirds()
    {
        Birds[] birds = new Birds[names.length];
        for(int i = 0; i<birds.length;i++)
            birds[i] = new Birds(names[i], photo_res[i]);

        return birds;
    }
}