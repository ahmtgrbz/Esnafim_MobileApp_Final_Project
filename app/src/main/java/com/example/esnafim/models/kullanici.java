package com.example.esnafim.models;

public class kullanici {
    private String kullanici_id;
    private String kullanici_sifre;
    private String kullanici_isim;

    public void setKullanici_id(String kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public void setKullanici_sifre(String kullanici_sifre) {
        this.kullanici_sifre = kullanici_sifre;
    }

    public void setKullanici_isim(String kullanici_isim) {
        this.kullanici_isim = kullanici_isim;
    }

    public String getKullanici_id() {
        return kullanici_id;
    }

    public String getKullanici_sifre() {
        return kullanici_sifre;
    }

    public String getKullanici_isim() {
        return kullanici_isim;
    }

    public kullanici() {
        this.kullanici_id = "boş kullanıcı nesnesi";
        this.kullanici_sifre = "boş kullanıcı nesnesi";
        this.kullanici_isim = "boş kullanıcı nesnesi";
    }
    public kullanici(String kullanici_id, String kullanici_sifre, String kullanici_isim) {
        this.kullanici_id = kullanici_id;
        this.kullanici_sifre = kullanici_sifre;
        this.kullanici_isim = kullanici_isim;
    }
}
