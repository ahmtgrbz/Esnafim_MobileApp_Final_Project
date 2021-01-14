package com.example.esnafim.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.esnafim.Adapters.ProductSquarelistRvAdapter;
import com.example.esnafim.Adapters.ProductlistRvAdapter;
import com.example.esnafim.R;
import com.example.esnafim.models.ProductlistRvmodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Detailmenu extends AppCompatActivity {
    RecyclerView recyclerView,recyclerView2,recyclerView3,recyclerView4;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmenu);

        final ArrayList<ProductlistRvmodel> dana = new ArrayList<>();
        dana.add(new ProductlistRvmodel(R.drawable.product1, "Dana Antirikot","100 TL/Kg"));
        dana.add(new ProductlistRvmodel(R.drawable.product2, "Dana Kontrfile ","80 TL/Kg"));
        dana.add(new ProductlistRvmodel(R.drawable.product3, "Dana Burger Köftesi","60 TL/Kg"));
        dana.add(new ProductlistRvmodel(R.drawable.product1, "Dana Antirikot","100 TL/Kg"));
        dana.add(new ProductlistRvmodel(R.drawable.product2, "Dana Kontrfile ","80 TL/Kg"));
        dana.add(new ProductlistRvmodel(R.drawable.product3, "Dana Burger Köftesi","60 TL/Kg"));
        dana.add(new ProductlistRvmodel(R.drawable.product1, "Dana Antirikot","100 TL/Kg"));
        dana.add(new ProductlistRvmodel(R.drawable.product2, "Dana Kontrfile ","80 TL/Kg"));
        dana.add(new ProductlistRvmodel(R.drawable.product3, "Dana Burger Köftesi","60 TL/Kg"));

        recyclerView = (RecyclerView) findViewById(R.id.danaurunrvlistslider);
        ProductlistRvAdapter productlistRvAdapter = new ProductlistRvAdapter(this,dana);
        recyclerView.setAdapter(productlistRvAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        final ArrayList<ProductlistRvmodel> kuzu = new ArrayList<>();
        kuzu.add(new ProductlistRvmodel(R.drawable.product1, "Kuzu Antirikot","42 TL/Kg"));
        kuzu.add(new ProductlistRvmodel(R.drawable.product2, "Kuzu Kontrfile ","54 TL/Kg"));
        kuzu.add(new ProductlistRvmodel(R.drawable.product3, "Kuzu Burger Köftesi","67 TL/Kg"));
        kuzu.add(new ProductlistRvmodel(R.drawable.product3, "Karışık Kıyma","89 TL/Kg"));
        kuzu.add(new ProductlistRvmodel(R.drawable.product1, "Kuzu Antirikot","89 TL/Kg"));
        kuzu.add(new ProductlistRvmodel(R.drawable.product2, "Kuzu Kontrfile ","80 TL/Kg"));
        kuzu.add(new ProductlistRvmodel(R.drawable.product3, "Kuzu Burger Köftesi","60 TL/Kg"));

        recyclerView2 = (RecyclerView) findViewById(R.id.kuzuurunlerislider);
        ProductlistRvAdapter productlistRvAdapter2 = new ProductlistRvAdapter(this,kuzu);
        recyclerView2.setAdapter(productlistRvAdapter2);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        final ArrayList<ProductlistRvmodel> sarkuteri = new ArrayList<>();
        sarkuteri.add(new ProductlistRvmodel(R.drawable.product1, "Sucuk","100 TL/Kg"));
        sarkuteri.add(new ProductlistRvmodel(R.drawable.product2, "Salam ","80 TL/Kg"));
        sarkuteri.add(new ProductlistRvmodel(R.drawable.product3, "Pastırma","60 TL/Kg"));



        recyclerView3 = (RecyclerView) findViewById(R.id.sarkuterislider);
        ProductlistRvAdapter productlistRvAdapter3= new ProductlistRvAdapter(this,sarkuteri);
        recyclerView3.setAdapter(productlistRvAdapter3);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        linearLayoutManager3.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView3.setLayoutManager(linearLayoutManager3);


        final ArrayList<ProductlistRvmodel> Square = new ArrayList<>();
        Square.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Bonfile","100 TL/Kg"));
        Square.add(new ProductlistRvmodel(R.drawable.et, "Dana Kontrfile ","80 TL/Kg"));
        Square.add(new ProductlistRvmodel(R.drawable.dnabonf, "Et","60 TL/Kg"));
        Square.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Antirikot","100 TL/Kg"));
        Square.add(new ProductlistRvmodel(R.drawable.et, "Dana Kontrfile ","80 TL/Kg"));
        Square.add(new ProductlistRvmodel(R.drawable.et, "Dana Burger Köftesi","60 TL/Kg"));
        Square.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Antirikot","100 TL/Kg"));
        Square.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Kontrfile ","80 TL/Kg"));
        Square.add(new ProductlistRvmodel(R.drawable.dnabonf, "Dana Burger Köftesi","60 TL/Kg"));

        recyclerView4 = (RecyclerView) findViewById(R.id.spetslider);
        ProductSquarelistRvAdapter ProductSquarelistRvAdapter = new ProductSquarelistRvAdapter(this,Square);
        recyclerView4.setAdapter(ProductSquarelistRvAdapter);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(this);
        linearLayoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView4.setLayoutManager(linearLayoutManager4);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
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
                    case R.id.sepet:
                        Intent intents = new Intent(getApplicationContext(),chart.class);
                        startActivity(intents);
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


        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), home_screen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade,R.anim.fadeout);
                finish();
            }
        },2900);*/





    }
}