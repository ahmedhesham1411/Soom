package com.example.soomtest.Model;

public class MainCategoryModel {
    int Main_Cat_Id;
    int image;
    String name;

    public MainCategoryModel(int Main_Cat_Id,int image, String name) {
        this.Main_Cat_Id = Main_Cat_Id;
        this.image = image;
        this.name = name;
    }

    public int getMain_Cat_Id() {
        return Main_Cat_Id;
    }

    public void setMain_Cat_Id(int main_Cat_Id) {
        Main_Cat_Id = main_Cat_Id;
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
