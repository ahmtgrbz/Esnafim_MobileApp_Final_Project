package com.example.esnafim.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.esnafim.Adapters.KategoriRvAdapter;
import com.example.esnafim.DatabaseAccess;
import com.example.esnafim.R;
import com.example.esnafim.Adapters.dukkanRvAdapter;
import com.example.esnafim.models.KategoriRvModel;
import com.example.esnafim.models.dukkanRvModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class home_screen extends AppCompatActivity  {

    private com.example.esnafim.Adapters.dukkanRvAdapter dukkanRvAdapter;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView;
    private KategoriRvAdapter kategoriRvAdapter;
    private BottomNavigationView bottomNavigationView;
    private ViewFlipper vFlipper;
    public static ArrayList<dukkanRvModel> dukkans;
    EditText editText;

    protected void onResume() {
        super.onResume();
        editText.clearFocus();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        editText = findViewById(R.id.search_bar);
        editText.setFocusableInTouchMode(true);


        final ArrayList<KategoriRvModel> item = new ArrayList<>();
        item.add(new KategoriRvModel(R.drawable.et, "Et"));
        item.add(new KategoriRvModel(R.drawable.sebze, "Sebze"));
        item.add(new KategoriRvModel(R.drawable.mesrubat, "Meşrubat"));
        item.add(new KategoriRvModel(R.drawable.temizlik, "Temizlik"));
        item.add(new KategoriRvModel(R.drawable.et, "Et"));
        item.add(new KategoriRvModel(R.drawable.sebze, "Sebze"));
        item.add(new KategoriRvModel(R.drawable.mesrubat, "Meşrubat"));
        item.add(new KategoriRvModel(R.drawable.temizlik, "Temizlik"));
        item.add(new KategoriRvModel(R.drawable.et, "Et"));
        item.add(new KategoriRvModel(R.drawable.sebze, "Sebze"));
        item.add(new KategoriRvModel(R.drawable.mesrubat, "Meşrubat"));
        item.add(new KategoriRvModel(R.drawable.temizlik, "Temizlik"));

        recyclerView = findViewById(R.id.spetslider);
        kategoriRvAdapter = new KategoriRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(kategoriRvAdapter);
        Log.e("database","123");
        DatabaseAccess databaseAccess = new DatabaseAccess(this);
        databaseAccess.open();

        try {
            ArrayList<dukkanRvModel> dukkans = databaseAccess.dukkanlariListele();
            recyclerView2 = findViewById(R.id.searchsliders);
            dukkanRvAdapter = new dukkanRvAdapter(dukkans,getApplicationContext());
            Context context1 = this;
            recyclerView2.setLayoutManager(new LinearLayoutManager(context1, LinearLayoutManager.VERTICAL, false));
            recyclerView2.setAdapter(dukkanRvAdapter);
        }catch (Exception a) {Log.e("database",""+a);}

        //dukkans.add(new dukkanRvModel(0,"şarküteri","kasap",2131230896));
        //dukkans.add(new dukkanRvModel(2131230897, "Halil Kasap"));
        //dukkans.add(new dukkanRvModel(R.drawable.pn2, "Hayat Pastanesi"));
        //dukkans.add(new dukkanRvModel(R.drawable.pn, "Kuzey Ekmek Fırını"));
        //dukkans.add(new dukkanRvModel(R.drawable.pn, "Bebek Market"));
        //dukkans.add(new dukkanRvModel(R.drawable.pn2, "Elif Eczanesi"));*/

        databaseAccess.close();
        int bannerphotos[] = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};

        vFlipper = findViewById(R.id.Banner);
        for (int img : bannerphotos) {
            flip(img);
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.anamenu);
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
                        startActivity(new Intent(getApplicationContext(),chart.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        DatabaseAccess dAccess = DatabaseAccess.getInstance(getApplicationContext());
        dAccess.open();

        Log.e("database","");
        dAccess.close();


    }



    public void flip(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        vFlipper.addView(imageView);
        vFlipper.setFlipInterval(6000);
        vFlipper.setAutoStart(true);
        vFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        vFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }


}