package com.example.exportaves;

import android.location.Location;

public class UserSession {
    private static UserSession instance;
    private static Location userLocation;

    private boolean isLoggedIn = false;
    private String userId;
    private String adSoyad;
    private String ePosta;

    private UserSession() {
        // Singleton sınıf, örneğin birden fazla kullanıcı oluşturulmasını önlemek için
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUserData(String userId, String adSoyad, String ePosta) {
        this.userId = userId;
        this.adSoyad = adSoyad;
        this.ePosta = ePosta;
    }

    public String getUserId() {
        return userId;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public String getEPosta() {
        return ePosta;
    }

    public Location getUserLocation() {
        return userLocation;
    }

    public static void setUserLocation(Location location) {
        userLocation = location;
    }

    public void clearUserData() {
        userId = null;
        adSoyad = null;
        ePosta = null;
        isLoggedIn = false;
        userLocation = null;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
