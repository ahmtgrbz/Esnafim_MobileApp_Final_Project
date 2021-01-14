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
import com.example.esnafim.R;
import com.example.esnafim.models.MessageRvModel;
import com.example.esnafim.models.ProductlistRvmodel;


import java.util.ArrayList;

    public class MessageRvAdapter extends RecyclerView.Adapter<com.example.esnafim.Adapters.MessageRvAdapter.ProductlistRVViewHolder> {

        ArrayList<MessageRvModel> mItems;
        LayoutInflater inflater;
        Context context;

        public  MessageRvAdapter(Context context, ArrayList<MessageRvModel> data){
            this.context=context;
            inflater =LayoutInflater.from(context);
            this.mItems=data;
        }

        @NonNull
        @Override

        public com.example.esnafim.Adapters.MessageRvAdapter.ProductlistRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.message_rv_rightitem,parent,false);

            com.example.esnafim.Adapters.MessageRvAdapter.ProductlistRVViewHolder ViewHolder = new com.example.esnafim.Adapters.MessageRvAdapter.ProductlistRVViewHolder(v);
            return ViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.esnafim.Adapters.MessageRvAdapter.ProductlistRVViewHolder holder, int position) {
            MessageRvModel secilenurun = mItems.get(position);
            holder.setData(secilenurun,position);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }


        public class ProductlistRVViewHolder extends RecyclerView.ViewHolder {

            TextView kim1,mesaj1,kim2,mesaj2;
            int positiondeğeri = 0;

            public ProductlistRVViewHolder(@NonNull View itemView) {
                super(itemView);
                kim1 = (TextView) itemView.findViewById(R.id.wholeft);
                mesaj1 = (TextView) itemView.findViewById(R.id.lefttext);
                kim2 = (TextView) itemView.findViewById(R.id.whoright);
                mesaj2= (TextView) itemView.findViewById(R.id.righttext);
            }

            public void setData(MessageRvModel msg, int position) {
                this.mesaj1.setText(msg.getMesaj1());
                this.mesaj2.setText(msg.getMesaj2());
                this.positiondeğeri=position;
            }
        }
    }
