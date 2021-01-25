package com.example.esnafim.models;

public class ProductlistRvmodel {
    private int ürünid;
    private int imageID;
    private String baslik;
    private String fiyat;
    private int satıcı_id;
    private String tip;
    private String tur;



    public ProductlistRvmodel(int ürünid, String baslik, String fiyat, int satıcı_id, int imageID, String tip,String tur) {
        this.ürünid = ürünid;
        this.imageID = imageID;
        this.baslik = baslik;
        this.fiyat = fiyat;
        this.satıcı_id =satıcı_id;
        this.tip = tip;
        this.tur = tur;

    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getTur() {
        return tur;
    }

    public void setÜrünid(int ürünid) {
        this.ürünid = ürünid;
    }

    public int getÜrünid() {
        return ürünid;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setSatıcı_id(int satıcı_id) {
        this.satıcı_id = satıcı_id;
    }

    public int getSatıcı_id() {
        return satıcı_id;
    }

    public int getImageID() {
        return imageID;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }
}
