package com.herokuapp.chinaprime.Objects;

/**
 * Created by Andrew Cho on 3/16/2015.
 */
public class Item {
    private String mTitle;
    private int mImage;
    private int mRetailPrice;
    private int mPrice;
    private boolean mIsSaved;

    public Item(String mTitle, int mImage, int mRetailPrice, int mPrice) {
        this.mTitle = mTitle;
        this.mImage = mImage;
        this.mRetailPrice = mRetailPrice;
        this.mPrice =  mPrice;
        this.mIsSaved = false;
    }


    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public int getmRetailPrice() {
        return mRetailPrice;
    }

    public void setmRetailPrice(int mRetailPrice) {
        this.mRetailPrice = mRetailPrice;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public boolean ismIsSaved() {
        return mIsSaved;
    }

    public void setmIsSaved(boolean mIsSaved) {
        this.mIsSaved = mIsSaved;
    }
}
