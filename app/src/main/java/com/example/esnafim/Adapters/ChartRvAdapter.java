package com.example.esnafim.Adapters;
import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esnafim.DatabaseAccess;
import com.example.esnafim.R;
import com.example.esnafim.models.ProductlistRvmodel;


import java.util.ArrayList;

public class ChartRvAdapter extends RecyclerView.Adapter<ChartRvAdapter.ProductlistRVViewHolder> {

    ArrayList<ProductlistRvmodel> mItems;
    LayoutInflater inflater;
    Context context;
    DatabaseAccess databaseAccess;
    public  ChartRvAdapter(Context context, ArrayList<ProductlistRvmodel> data){
        this.context=context;
        inflater =LayoutInflater.from(context);
        this.mItems=data;
    }

    @NonNull
    @Override

    public ProductlistRVViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.chart_rv_item,parent,false);
        ChartRvAdapter.ProductlistRVViewHolder ViewHolder = new ChartRvAdapter.ProductlistRVViewHolder(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductlistRVViewHolder holder, int position) {
        ProductlistRvmodel secilenurun = mItems.get(position);
        holder.setData(secilenurun,position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    public void deleteItem(int position){
        try {
            databaseAccess = new DatabaseAccess(context);
            databaseAccess.open();
            boolean a = databaseAccess.sepettenkaldır(mItems.get(position),"Onur");
            databaseAccess.close();
            String adı = mItems.get(position).getBaslik();
            mItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,mItems.size());
            if (a == true){Toast.makeText(context, adı+" adlı ürün sepetten kaldırıldı ", Toast.LENGTH_SHORT).show();}
            else{Toast.makeText(context, "Ürün sepetten kaldırılırken hata ile karşılaşıldı ", Toast.LENGTH_SHORT).show();}

        } catch (Exception e) {
            Toast.makeText(context, "Seçilen ürün sepette değil", Toast.LENGTH_SHORT).show();
        }


    }

    public class ProductlistRVViewHolder extends RecyclerView.ViewHolder {

        TextView urunadi,urunfiyati;
        ImageView urunresmi,silresmi;
        int positiondeğeri = 0;

        public ProductlistRVViewHolder(@NonNull View itemView) {
            super(itemView);
            urunadi = (TextView) itemView.findViewById(R.id.charturunadi);
            urunfiyati = (TextView) itemView.findViewById(R.id.chartfiyat);
            urunresmi = (ImageView) itemView.findViewById(R.id.charturunresmi);
            silresmi = (ImageView) itemView.findViewById(R.id.deleteProductButton);

            silresmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(positiondeğeri);
                }
            });

        }

        public void setData(ProductlistRvmodel secilenurun, int position) {
            this.urunadi.setText(secilenurun.getBaslik());
            this.urunfiyati.setText(secilenurun.getFiyat());
            this.urunresmi.setImageResource(secilenurun.getImageID());
            this.positiondeğeri=position;
        }
    }





}
