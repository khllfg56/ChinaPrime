package com.herokuapp.chinaprime.Utility.Other;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Andrew Cho on 6/15/2015.
 */
public class AddCartTextView extends TextView{
    private Boolean isAdded = false;

    public AddCartTextView(Context context) {
        super(context);
    }

    public Boolean getIsAdded() {
        return isAdded;
    }

    public void setIsAdded(Boolean isAdded) {
        this.isAdded = isAdded;
    }

}
