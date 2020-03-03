package com.example.soomtest.Model;

public class Price_model {
    int image;
    int price;

    public Price_model(int image, int price) {
        this.image = image;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
