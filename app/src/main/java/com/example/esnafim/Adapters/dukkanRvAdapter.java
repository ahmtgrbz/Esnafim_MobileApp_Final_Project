package com.example.esnafim.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esnafim.R;
import com.example.esnafim.activities.Detailmenu;
import com.example.esnafim.activities.SearchMenu;
import com.example.esnafim.activities.home_screen;
import com.example.esnafim.models.MessageRvModel;
import com.example.esnafim.models.dukkanRvModel;

import java.util.ArrayList;


public class dukkanRvAdapter extends RecyclerView.Adapter<dukkanRvAdapter.StaticRVViewHolder>{

    private ArrayList<dukkanRvModel> items;
    int row_index = -1;
    Context mcontext;



    public dukkanRvAdapter(ArrayList<dukkanRvModel> items) {
        this.items = items;
    }




    public dukkanRvAdapter(ArrayList<dukkanRvModel> dukkans, Context applicationContext) {
        this.mcontext=applicationContext;
        this.items=dukkans;
    }


    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dukkan_rv_item,parent,false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }




    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, final int position) {
        dukkanRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());
        holder.ConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,Detailmenu.class);
                mcontext.startActivity(intent);
            }
        });
    }



    public int getItemCount() {
        return items.size();
    }




    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{
        RatingBar ratingBar;
        TextView textView;
        ImageView imageView;

        ConstraintLayout ConstraintLayout;
            public StaticRVViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.dukkanresmi);
                textView = itemView.findViewById(R.id.dukkanadı);
                ConstraintLayout = itemView.findViewById(R.id.constraintLayout2);
                ratingBar = itemView.findViewById(R.id.rtbar);

            }
        }

}
