package com.example.parsingjsonresponse;

public class Model {

    private String name;
    private String brand;
    private String style;
    private String alcohol ;



    public Model(String name, String brand, String style, String alcohol) {
        this.name = name;
        this.brand = brand;
        this.style = style;
        this.alcohol = alcohol;
    }

    public Model() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }




}
