package com.herokuapp.chinaprime;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.herokuapp.chinaprime.Objects.Item;


public class ViewItemActivity extends ActionBarActivity {
    private ImageView mItemImage;
    private TextView mItemPrice;
    private TextView mItemPriceOriginal;
    private TextView mItemPriceSavings;
    private TextView mItemDescription;
    private Item item;

    private int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item_activity);

        Bundle extras = this.getIntent().getExtras();
        this.itemPosition = extras.getInt("Position");
        this.item = MainActivity.mItems.get(itemPosition);

        this.mItemImage = (ImageView)findViewById(R.id.ivItemView);
        this.mItemPrice = (TextView)findViewById(R.id.tvItemPrice);
        this.mItemPriceOriginal = (TextView) findViewById(R.id.tvOriginalPrice);
        this.mItemPriceSavings = (TextView) findViewById(R.id.tvSavingsAmount);
        this.mItemDescription = (TextView)findViewById(R.id.tvItemDescription);

        this.mItemPrice.setText("$" + this.item.getmPrice());
        this.mItemImage.setImageResource(this.item.getmImage());
        this.mItemPriceOriginal.setText("Original $" + this.item.getmRetailPrice());
        this.mItemPriceSavings.setText("Savings $" + (this.item.getmRetailPrice()-this.item.getmPrice()));
        this.mItemDescription.setText("Description");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_item_activty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item_home clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case R.id.favorite:
                MainActivity.mSavedItems.add(this.itemPosition);
                break;
            case R.id.share:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /********Intents*******/
    private void goToShoppingCart() {
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        startActivity(intent);
    }
}
