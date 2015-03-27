package com.herokuapp.chinaprime.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.herokuapp.chinaprime.Objects.Item;
import com.herokuapp.chinaprime.MainActivity;
import com.herokuapp.chinaprime.R;
import com.herokuapp.chinaprime.Objects.ViewHolder;

import java.util.ArrayList;

/**
 * Created by Andrew Cho on 1/27/15.
 */
public class AdapterMain extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Item> items;
    private String DEBUG = "AdapterMain";

    ImageView imageViewLeft;
    ImageView imageViewRight;

    CheckBox savedLeft;
    CheckBox savedRight;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterMain(ArrayList<Item> items) {
        this.items = items;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.i(DEBUG, "" + position);
        int leftPosition = position * 2;
        int rightPosition = position * 2 + 1;

        imageViewLeft = (ImageView) holder.view.findViewById(R.id.ivImageLeft);
        imageViewRight = (ImageView) holder.view.findViewById(R.id.ivImageRight);
        imageViewLeft.setTag(leftPosition);
        imageViewRight.setTag(rightPosition);

        imageViewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int)v.getTag();
                Log.i(DEBUG, position+"");
                MainActivity ma = (MainActivity)v.getContext();
                ma.goToViewItem(position);
            }
        });
        imageViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int)v.getTag();
                Log.i(DEBUG, position+"");
                MainActivity ma = (MainActivity)v.getContext();
                ma.goToViewItem(position);
            }
        });


        imageViewLeft.setImageResource(items.get(leftPosition).getmImage());
        if (rightPosition == items.size()) {
            CardView temp = (CardView) holder.view.findViewById(R.id.card_view_right);
            temp.setVisibility(View.INVISIBLE);
        } else {
            imageViewRight.setImageResource(items.get(rightPosition).getmImage());
        }
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (items.size()+1)/2;
    }

    /*
    * removes deck from deckView
    */
    public void removeAt(int position) {
        if (position > -1 && position < items.size()) {
            items.remove(position);
            this.notifyItemRemoved(position);
        }
    }
    /*
     * adds deck to deckView
     */
    public void add(Item item) {
        this.items.add(item);
    }

    public void saveItems() {

    }
}