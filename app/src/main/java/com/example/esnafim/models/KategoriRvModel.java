package com.example.esnafim.models;

public class KategoriRvModel {
    private int image;
    private String text;

    public KategoriRvModel(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

}
