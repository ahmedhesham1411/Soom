package com.example.soomtest.Model;

public class Sub_Cat_Model {
    Boolean favourite;
    int image;
    String name;

    public Sub_Cat_Model(Boolean favourite, int image, String name) {
        this.favourite = favourite;
        this.image = image;
        this.name = name;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
