package com.example.esnafim.models;

import android.widget.ImageView;
import android.widget.TextView;

public class MessageRvModel {
    String mesaj1;
    String gönderen;
    String alici;
    int mesajsirasi;

    public MessageRvModel(String gönderen, String alici,String mesaj1, int mesajsirasi) {
        this.mesaj1 = mesaj1;
        this.gönderen = gönderen;
        this.alici = alici;
        this.mesajsirasi = mesajsirasi;
    }

    public void setMesaj1(String mesaj1) {
        this.mesaj1 = mesaj1;
    }

    public void setGönderen(String gönderen) {
        this.gönderen = gönderen;
    }

    public void setAlici(String alici) {
        this.alici = alici;
    }

    public void setMesajsirasi(int mesajsirasi) {
        this.mesajsirasi = mesajsirasi;
    }

    public String getMesaj1() {
        return mesaj1;
    }

    public String getGönderen() {
        return gönderen;
    }

    public String getAlici() {
        return alici;
    }

    public int getMesajsirasi() {
        return mesajsirasi;
    }
}


