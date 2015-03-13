package com.herokuapp.chinaprime;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrew Cho on 1/27/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Deck> decks;
    private int previousPosition = -1;
    private String DEBUG = "MyAdapter";

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        public View view;

        public ViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deck, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView title = (TextView) holder.view.findViewById(R.id.tvTitle);
        TextView desc = (TextView) holder.view.findViewById(R.id.tvDesc);
        //final ImageView imageView = (ImageView) holder.view.findViewById(R.id.imageView);

        title.setText(decks.get(position).getTitle());
        desc.setText(decks.get(position).getText());
        //imageView.setImageResource(cards.get(position).getImage());
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return decks.size();
    }

    //called when item clicked, puts previous clicked as blank and sets new text
    public void showDeckPreview(View view, int position) {
        if (this.previousPosition != -1 && previousPosition < decks.size() && position < decks.size()) {
            Log.i(DEBUG, "Set blank");
            decks.get(previousPosition).setBlank();
        }
        try {
            decks.get(position).setDesc();
            previousPosition = position;
            this.notifyDataSetChanged();
        } catch(Exception e) {
            Log.e("My Adapter", e.toString());
        }
    }

    /*
    * removes deck from deckView
    */
    public void removeAt(int position) {
        if (position > -1 && position < decks.size()) {
            decks.remove(position);
            this.notifyItemRemoved(position);
        }
    }
    /*
     * adds deck to deckView
     */
    public void add(Deck deck) {
        this.decks.add(deck);
    }
}