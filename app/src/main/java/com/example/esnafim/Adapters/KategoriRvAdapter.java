package com.example.esnafim.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.esnafim.R;
import com.example.esnafim.models.KategoriRvModel;
import java.util.ArrayList;



public class KategoriRvAdapter extends RecyclerView.Adapter<KategoriRvAdapter.StaticRVViewHolder>{

    private ArrayList<KategoriRvModel> items;
    int row_index = -1;
    public KategoriRvAdapter(ArrayList<KategoriRvModel> items) {
        this.items = items;
    }




    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_rv_item,parent,false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }




    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, final int position) {
        KategoriRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        holder.ConstraintLayout.setOnClickListener(new View.OnClickListener() {
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
        ConstraintLayout ConstraintLayout;
            public StaticRVViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.sscardresmi);
                textView = itemView.findViewById(R.id.sscardadı);
                ConstraintLayout = itemView.findViewById(R.id.sscardview);
            }
        }
}
