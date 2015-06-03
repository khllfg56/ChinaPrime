package com.herokuapp.chinaprime.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.herokuapp.chinaprime.Objects.Item;
import com.herokuapp.chinaprime.MainActivity;
import com.herokuapp.chinaprime.R;
import com.herokuapp.chinaprime.Objects.ViewHolder;
import com.herokuapp.chinaprime.ShoppingCartActivity;

import java.util.ArrayList;

/**
 * Created by Andrew Cho on 3/23/2015.
 */
public class AdapterCart extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Item> cartItems;
    private ImageView cartItem;
    private Spinner itemQuantityDropdown;
    private Context context;
    private String DEBUG = "AdapterCart";

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterCart(ArrayList<Item> items, Context context) {
        this.cartItems = items;
        this.context = context;
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
        itemQuantityDropdown = (Spinner)holder.view.findViewById(R.id.spItemQuantity);

        cartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                Log.i(DEBUG, position + "");

                //start Activity
                MainActivity ma = (MainActivity) v.getContext();
                ma.goToViewItem(position);
            }
        });
        cartItem.setImageResource(cartItems.get(position).getmImage());

        String[] numbers = new String[]{"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, numbers);
        itemQuantityDropdown.setAdapter(adapter);
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
