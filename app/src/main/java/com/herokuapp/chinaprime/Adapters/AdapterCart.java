package com.herokuapp.chinaprime.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.herokuapp.chinaprime.Objects.Item;
import com.herokuapp.chinaprime.MainActivity;
import com.herokuapp.chinaprime.R;
import com.herokuapp.chinaprime.Objects.ViewHolder;

import java.util.ArrayList;

/**
 * Created by Andrew Cho on 3/23/2015.
 */
public class AdapterCart extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Item> items;
    private String DEBUG = "AdapterCart";

    ImageView cartItem;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterCart(ArrayList<Item> items) {
        this.items = items;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        cartItem = (ImageView) holder.view.findViewById(R.id.ivCartImage);
        cartItem.setTag(position);

        cartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int)v.getTag();
                Log.i(DEBUG, position+"");

                //start Activity
                MainActivity ma = (MainActivity)v.getContext();
                ma.goToViewItem(position);
            }
        });

        cartItem.setImageResource(items.get(position).getmImage());
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}
