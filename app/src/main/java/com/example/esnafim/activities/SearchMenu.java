package com.example.esnafim.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.esnafim.Adapters.SearchmenuRvAdapter;
import com.example.esnafim.R;
import com.example.esnafim.models.KategoriRvModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SearchMenu extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchmenu);


        final ArrayList<KategoriRvModel> item = new ArrayList<>();
        item.add(new KategoriRvModel(R.drawable.kasapcard, "Kasap"));
        item.add(new KategoriRvModel(R.drawable.marketcard, "Market"));
        item.add(new KategoriRvModel(R.drawable.mnvcard, "Manav"));
        item.add(new KategoriRvModel(R.drawable.pst, "Pastane"));
        item.add(new KategoriRvModel(R.drawable.frncard, "Fırın"));
        item.add(new KategoriRvModel(R.drawable.eczcard, "Eczane"));
        item.add(new KategoriRvModel(R.drawable.kirtasiyecard, "Kırtasiye"));
        item.add(new KategoriRvModel(R.drawable.textilcard, "Tekstil"));


        recyclerView = findViewById(R.id.searchsliders);
        SearchmenuRvAdapter searchmenuRvAdapter = new SearchmenuRvAdapter(item);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(searchmenuRvAdapter);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ara);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.anamenu:
                        startActivity(new Intent(getApplicationContext(), home_screen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.destek:
                        startActivity(new Intent(getApplicationContext(), livechat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.sepet:
                        startActivity(new Intent(getApplicationContext(),chart.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}