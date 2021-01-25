package com.example.esnafim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.esnafim.models.MessageRvModel;
import com.example.esnafim.models.ProductlistRvmodel;
import com.example.esnafim.models.dukkanRvModel;
import com.example.esnafim.models.kullanici;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    public DatabaseAccess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public  void open(){
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db != null){
            this.db.close();
        }
    }

   public String girişYap(String kullanici_id,String kullanici_sifre){
       c=db.rawQuery("select * from kullanicilar where kullanici_id = '"+kullanici_id+"'", new String[]{} );
       if (c.getCount()==0) {
           return "kullanıcı bulunamadı";
       }else {
           if(c.getString(0) == kullanici_id && c.getString(1) == kullanici_sifre){
               return c.getString(3);
           }else return "Hatalı Giris Bilgisi";
       }
   }

    public int kayitOl(String kullanici_id,String kullanici_sifre,String kullanici_isim){
        c=db.rawQuery("select * from kullanicilar where kullanici_id = '"+kullanici_id+"'", new String[]{} );
        if (c.getCount()==0) {
            ContentValues c1 = new ContentValues();
            c1.put("kullanici_id", kullanici_id);
            c1.put("kullanici_sifre",kullanici_sifre );
            c1.put("kullanici_isim", kullanici_isim);
            long a = db.insert("kullanicilar", null, c1);
            if (a == -1) return -1;
            else return 1;
        }else {
            return 0;
        }
        // eğer kullanıcı önceden kayıtlı ise 0 kullanici kayıtli değil ama kayıt sırsında hata varsa -1, kullanıcının kaydı başarı ile tamamlanmış ise 1 döndürür.
    }

    public boolean mesajGonder(String kullanici_id,String alici,String mesaj){
    ArrayList<MessageRvModel> mesajlar_tumu = new ArrayList();
    c=db.rawQuery("select * from mesajlar where gonderen= '"+kullanici_id+"'", new String[]{} );

    if (c.getCount()==0){
        ContentValues contentValues = new ContentValues();
        ContentValues msjgonder = new ContentValues();
        contentValues.put("gonderen","admin");
        contentValues.put("alici",alici);
        contentValues.put("mesaj","Nasıl Yardımcı olabiliriz ?");
        long  firstmsg = db.insert("mesajlar",null,contentValues);
        msjgonder.put("gonderen",kullanici_id);
        msjgonder.put("alici",alici);
        msjgonder.put("mesaj",mesaj);
        long msj = db.insert("mesajlar",null,msjgonder);

        if (firstmsg == -1 || msj == -1){
            return false;
        }else return true;
    }else {
        ContentValues msjgonder = new ContentValues();
        msjgonder.put("gonderen",kullanici_id);
        msjgonder.put("alici",alici);
        msjgonder.put("mesaj",mesaj);
        long msj = db.insert("mesajlar",null,msjgonder);
        if(msj == -1){
            return false;
        }else return true;
    }
    }


    public ArrayList<MessageRvModel> mesajlariGoster(String gonderen,String alici) {
        ArrayList<MessageRvModel> mesajlar_tumu = new ArrayList<MessageRvModel>();
        c=db.rawQuery("select * from mesajlar", new String[]{} );
        if (c.getCount()==0){
            MessageRvModel ms = new MessageRvModel("admin","alici","Nasıl Yardımcı olabiliriz ?",0);
            mesajlar_tumu.add(ms);
        }else{
            c.moveToFirst();
            while (!c.isAfterLast()) {
                Log.e("database", c.getString(0)+" ve0 "+ c.getString(1));
                if (  (c.getString(0).equals(gonderen)  &&  c.getString(1).equals(alici))) {

                    mesajlar_tumu.add(new MessageRvModel(c.getString(0), c.getString(1), c.getString(2), c.getInt(3)));
                } if (  (c.getString(0).equals(alici)  &&  c.getString(1).equals(gonderen))) {

                    mesajlar_tumu.add(new MessageRvModel(c.getString(0), c.getString(1), c.getString(2), c.getInt(3)));
                }

                c.moveToNext();
            }
        }
        Log.e("database", " son ");
        return mesajlar_tumu;
    }

    public  ArrayList<dukkanRvModel> dukkanlariListele(){
        ArrayList<dukkanRvModel> dukkanlar_tumu = new ArrayList<dukkanRvModel>();
        c=db.rawQuery("select * from dukkanlar", new String[]{});
              if (c.getCount()==0){
                  dukkanRvModel ms = new dukkanRvModel(0,"Dukkan Bulunamadı Kasap","kasap",2131230897);
                  dukkanlar_tumu.add(ms);
                  return  dukkanlar_tumu;
              }else{
                  c.moveToFirst();
                  while (!c.isAfterLast()){
                      dukkanlar_tumu.add(new dukkanRvModel(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3)));
                      c.moveToNext();
                  }
              }
              return dukkanlar_tumu;
    }

    public ArrayList<dukkanRvModel> dukkanara(String tur){
        ArrayList<dukkanRvModel> aranmaliste = new ArrayList<dukkanRvModel>();
        c=db.rawQuery("select * from dukkanlar where dukkan_turu= '"+tur+"'", new String[]{} );
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(2)==tur){
            aranmaliste.add(new dukkanRvModel(c.getInt(3),c.getString(1),c.getString(2),c.getInt(0)));}
            c.moveToNext();
        }
        return aranmaliste;
    }


    public ArrayList<ProductlistRvmodel> urunListele(int dukkanid, String yön, String tür){
        ArrayList<ProductlistRvmodel> urunliste = new ArrayList<ProductlistRvmodel>();
        c=db.rawQuery("select * from urunler where satan_dukkan_id= '"+dukkanid+"'", new String[]{} );

        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(5).equals(yön) && c.getString(6).equals(tür)){
            urunliste.add(new ProductlistRvmodel(c.getInt(0),c.getString(1),c.getString(2)+" TL/Kg",c.getInt(3),c.getInt(4),c.getString(5),c.getString(6)));}
            c.moveToNext();
        }
        return urunliste;
    }

    public boolean sepetekele (ProductlistRvmodel product,String Alıcı){
        c=db.rawQuery("select * from sepet where alıcı_id= '"+Alıcı+"'", new String[]{} );

        ContentValues cont = new ContentValues();
        cont.put("ürünid",product.getÜrünid());
        cont.put("baslik",product.getBaslik());
        cont.put("fiyat",product.getFiyat());
        cont.put("satıcı_id",product.getSatıcı_id());
        cont.put("tip",product.getTip());
        cont.put("tur",product.getTur());
        cont.put("alıcı_id",Alıcı);
        cont.put("imageID",product.getImageID());
        /*if(product.getTur() == "yatay"){
            cont.put("imageID",2131230841);
        }else{
         cont.put("imageID",product.getImageID());
        }
         */

        long a = db.insert("sepet",null,cont);
        if(a == -1)return false;
        else return true;
    }

    public boolean sepettenkaldır (ProductlistRvmodel product,String Alıcı){
        c=db.rawQuery("select * from sepet where alıcı_id= '"+Alıcı+"'", new String[]{} );
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getInt(0) == product.getÜrünid()){
                long a = db.delete("sepet","ürünid="+product.getÜrünid(),null);
                if(a == -1)return false;
                else return true;
            }
            c.moveToNext();
        }
        return false;

    }

    public ArrayList<ProductlistRvmodel> sepetigetir(String Alıcı){
        ArrayList<ProductlistRvmodel> sepetigetir = new ArrayList<ProductlistRvmodel>();
        c=db.rawQuery("select * from sepet where alıcı_id= '"+Alıcı+"'", new String[]{} );
        c.moveToFirst();
        while (!c.isAfterLast()){
                if(c.getString(7).equals(Alıcı)){
                    sepetigetir.add(new ProductlistRvmodel(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3),c.getInt(4),c.getString(5),c.getString(6)));}
                c.moveToNext();
        }

        return sepetigetir;
    }
}


