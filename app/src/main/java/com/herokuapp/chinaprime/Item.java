package com.herokuapp.chinaprime;

/**
 * Created by Andrew Cho on 3/13/2015.
 */
public class Item {
    private String title;
    private int image;
    private int retailPrice;
    private int priceSold;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(int priceSold) {
        this.priceSold = priceSold;
    }
}
