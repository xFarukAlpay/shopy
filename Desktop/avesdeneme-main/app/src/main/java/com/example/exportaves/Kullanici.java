package com.example.exportaves;

public class Kullanici {
    private String ad_soyad;
    private String adres_1;
    private String adres_2;
    private String e_posta;
    private String sehir;
    private String sifre;
    private String telefon;

    // Boş constructor
    public Kullanici() {
    }

    // Getter ve Setter metotları
    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getAdres_1() {
        return adres_1;
    }

    public void setAdres_1(String adres_1) {
        this.adres_1 = adres_1;
    }

    public String getAdres_2() {
        return adres_2;
    }

    public void setAdres_2(String adres_2) {
        this.adres_2 = adres_2;
    }

    public String getE_posta() {
        return e_posta;
    }

    public void setE_posta(String e_posta) {
        this.e_posta = e_posta;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

