package com.example.esnafim.models;

import androidx.appcompat.widget.AppCompatRatingBar;

public class dukkanRvModel {
    private int image;
    private String text;
    private String sınıf;
    private int id;

    public dukkanRvModel(int id, String text, String sınıf,int image ) {
        this.image = image;
        this.text = text;
        this.sınıf = sınıf;
        this.id = id;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSınıf(String sınıf) {
        this.sınıf = sınıf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSınıf() {
        return sınıf;
    }

    public int getId() {
        return id;
    }




    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

}
