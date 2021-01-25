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

public class ProductSquarelistRvAdapter extends RecyclerView.Adapter<ProductSquarelistRvAdapter.ProductlistRVViewHolder> {
    DatabaseAccess databaseAccess;
    ArrayList<ProductlistRvmodel> mItems;
    LayoutInflater inflater;
    static ArrayList<ProductlistRvmodel> chartItems=new ArrayList<ProductlistRvmodel>();
    Context context;

    public static ArrayList<ProductlistRvmodel> chartItemslist(){
        return chartItems;
    }

    public  ProductSquarelistRvAdapter(Context context, ArrayList<ProductlistRvmodel> data){
        this.context=context;
        inflater =LayoutInflater.from(context);
        this.mItems=data;

    }

    @NonNull
    @Override

    public ProductlistRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.product_square_rv_item,parent,false);
        ProductSquarelistRvAdapter.ProductlistRVViewHolder ViewHolder = new ProductSquarelistRvAdapter.ProductlistRVViewHolder(v);
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
        databaseAccess = new DatabaseAccess(context);
        databaseAccess.open();
        databaseAccess.sepetigetir("Onur").size();
        try {
            if(databaseAccess.sepetigetir("Onur").size()>0) {
                boolean a =databaseAccess.sepettenkaldır(mItems.get(position),"Onur");
                    databaseAccess.close();
                    if (a == true){
                        Toast.makeText(context, "Sepetten "+ mItems.get(position).getBaslik()+" adlı ürünü sildiniz", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, "Beklenmedik Hata Sepetten ürün kaldırılamadı ", Toast.LENGTH_SHORT).show();
                    }
            }else
                Toast.makeText(context, " Sepetiniz boş lütfen ürün ekleyin ", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Seçilen ürün sepette değil", Toast.LENGTH_SHORT).show();
        }


    }
    public void addItem(int position) {

        databaseAccess = new DatabaseAccess(context);
        databaseAccess.open();
        boolean a = databaseAccess.sepetekele(mItems.get(position), "Onur");
        databaseAccess.close();
        if (a == true) {
            Toast.makeText(context, "Sepette" + mItems.get(position).getBaslik() + "adlı ürünü eklediniz", Toast.LENGTH_SHORT).show();
        }
    }

    public class ProductlistRVViewHolder extends RecyclerView.ViewHolder {

        TextView urunadi,urunfiyati;
        ImageView urunresmi,silresmi,chartaekleresmi;
        int positiondeğeri = 0;
        ProductlistRvmodel chartiçinkopya;


        public ProductlistRVViewHolder(@NonNull View itemView) {
            super(itemView);
            urunadi = (TextView) itemView.findViewById(R.id.sitemadı);
            urunfiyati = (TextView) itemView.findViewById(R.id.sfiyat);
            urunresmi = (ImageView) itemView.findViewById(R.id.rsm);
            silresmi = (ImageView) itemView.findViewById(R.id.sdeletechartbutton);
            chartaekleresmi = (ImageView) itemView.findViewById(R.id.saddchartbutton);

            silresmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(positiondeğeri);
                }
            });

            chartaekleresmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem(positiondeğeri);
                }
            });
        }

        public void setData(ProductlistRvmodel secilenurun, int position) {
            this.urunadi.setText(secilenurun.getBaslik());
            this.urunfiyati.setText(secilenurun.getFiyat());
            this.urunresmi.setImageResource(secilenurun.getImageID());
            this.positiondeğeri=position;
            this.chartiçinkopya=secilenurun;
        }
    }





}

