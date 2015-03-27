package com.herokuapp.chinaprime.Objects;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Andrew Cho on 3/23/2015.
 */

// Provide a reference to the views for each data item_home
// Complex data items may need more than one view per item_home, and
// you provide access to all the views for a data item_home in a view holder
public class ViewHolder extends RecyclerView.ViewHolder{
    // each data item_home is just a string in this case
    public View view;

    public ViewHolder(View v) {
        super(v);
        view = v;
    }
}