package com.example.esnafim.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.esnafim.Adapters.KategoriRvAdapter;
import com.example.esnafim.Adapters.MessageRvAdapter;
import com.example.esnafim.DatabaseAccess;
import com.example.esnafim.R;
import com.example.esnafim.models.KategoriRvModel;
import com.example.esnafim.models.MessageRvModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class livechat extends AppCompatActivity {
    DatabaseAccess databaseAccess;
    private BottomNavigationView bottomNavigationView;
    public RecyclerView recyclerView;
    MessageRvAdapter MessageRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livechat);

        databaseAccess = new DatabaseAccess(this);
        databaseAccess.open();
        final ArrayList<MessageRvModel> item =databaseAccess.mesajlariGoster("admin","sistem");
        databaseAccess.close();
        //Log.e("database", item.size()+" boyut");
        /*ArrayList<MessageRvModel> item = new ArrayList<MessageRvModel>();
        item.add(new MessageRvModel("admin","sistem","denemecis",0));*/

        recyclerView = findViewById(R.id.chatt);
        MessageRvAdapter = new MessageRvAdapter(this,item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(MessageRvAdapter);

        final EditText text1 = findViewById(R.id.writedtext);
        ImageView send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseAccess.open();
                databaseAccess.mesajGonder("Onur","admin",text1.getText().toString());
                text1.setText("");
                startActivity(new Intent(getApplicationContext(),livechat.class));
            }
        });

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