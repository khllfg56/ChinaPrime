package com.herokuapp.chinaprime;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewItemActivity extends ActionBarActivity {
    private ImageView mItemImage;
    private TextView mItemPrice;
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
        this.mItemDescription = (TextView)findViewById(R.id.tvItemDescription);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_item_activty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
