package com.example.esnafim.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.esnafim.Adapters.KategoriRvAdapter;
import com.example.esnafim.Adapters.MessageRvAdapter;
import com.example.esnafim.R;
import com.example.esnafim.models.KategoriRvModel;
import com.example.esnafim.models.MessageRvModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class livechat extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livechat);

        final ArrayList<MessageRvModel> item = new ArrayList<>();
        item.add(new MessageRvModel("Deneme","Dummy Deneme"));
        item.add(new MessageRvModel("Database ile tekrar yapılacak","Dummy Deneme"));

        recyclerView = findViewById(R.id.chatt);
        MessageRvAdapter MessageRvAdapter = new MessageRvAdapter(this,item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(MessageRvAdapter);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.destek);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ara:
                        startActivity(new Intent(getApplicationContext(), SearchMenu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.sepet:
                        startActivity(new Intent(getApplicationContext(),chart.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.anamenu:
                        startActivity(new Intent(getApplicationContext(),home_screen.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }
}