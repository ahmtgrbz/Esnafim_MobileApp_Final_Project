package com.example.esnafim.models;

public class ProductlistRvmodel {
    private int imageID;
    private String baslik;
    private String fiyat;

    public ProductlistRvmodel(int imageID, String baslik, String fiyat) {
        this.imageID = imageID;
        this.baslik = baslik;
        this.fiyat = fiyat;
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
