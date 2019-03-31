package com.example.collapsingtoolbar;

public class Restaurant {
    private String name;
    private String price;
    private int photoID;

    public Restaurant(String name, String price, int photoID) {
        this.name = name;
        this.price = price;
        this.photoID = photoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }
}
