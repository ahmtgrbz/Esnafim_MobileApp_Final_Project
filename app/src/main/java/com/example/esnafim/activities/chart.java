package com.example.esnafim.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.esnafim.Adapters.ChartRvAdapter;
import com.example.esnafim.R;
import com.example.esnafim.models.ProductlistRvmodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class chart extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.sepet);

        final ArrayList<ProductlistRvmodel> items = new ArrayList<>();
        items.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Bonfile","100 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.et, "Dana Kontrfile ","80 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.dnabonf, "Et","60 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Antirikot","100 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.et, "Dana Kontrfile ","80 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Bonfile","100 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.et, "Dana Kontrfile ","80 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.dnabonf, "Et","60 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Antirikot","100 TL/Kg"));
        items.add(new ProductlistRvmodel(R.drawable.et, "Dana Kontrfile ","80 TL/Kg"));

        recyclerView = (RecyclerView) findViewById(R.id.spetslider);
        ChartRvAdapter ChartRvAdapter = new ChartRvAdapter(this,items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ChartRvAdapter);






        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ara:
                        startActivity(new Intent(getApplicationContext(), SearchMenu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.destek:
                        startActivity(new Intent(getApplicationContext(),livechat.class));
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