package com.example.esnafim.models;

import android.widget.ImageView;
import android.widget.TextView;

public class MessageRvModel {
    String mesaj1,mesaj2;

    public String getMesaj1() {
        return mesaj1;
    }

    public void setMesaj1(String mesaj1) {
        this.mesaj1 = mesaj1;
    }

    public String getMesaj2() {
        return mesaj2;
    }

    public void setMesaj2(String mesaj2) {
        this.mesaj2 = mesaj2;
    }

    public MessageRvModel(String mesaj1, String mesaj2) {
        this.mesaj1 = mesaj1;
        this.mesaj2 = mesaj2;
    }
}

