package com.example.esnafim.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.esnafim.R;
import com.example.esnafim.models.KategoriRvModel;
import java.util.ArrayList;

public class SearchmenuRvAdapter extends RecyclerView.Adapter<SearchmenuRvAdapter.StaticRVViewHolder>{

    private ArrayList<KategoriRvModel> items;
    int row_index = -1;
    public SearchmenuRvAdapter(ArrayList<KategoriRvModel> items) {
        this.items = items;
    }



    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_rv_itrem,parent,false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }




    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, final int position) {
        KategoriRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        holder.Cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
            }
        });
    }



    public int getItemCount() {
        return items.size();
    }



    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        CardView Cardview;
        public StaticRVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sscardresmi);
            textView = itemView.findViewById(R.id.sscardadı);
            Cardview = itemView.findViewById(R.id.sscardview);
        }
    }
}
