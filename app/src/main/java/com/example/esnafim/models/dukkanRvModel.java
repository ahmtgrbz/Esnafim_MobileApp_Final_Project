package com.example.esnafim.models;

import androidx.appcompat.widget.AppCompatRatingBar;

public class dukkanRvModel {
    private int image;
    private String text;


    public dukkanRvModel(int image, String text) {
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
