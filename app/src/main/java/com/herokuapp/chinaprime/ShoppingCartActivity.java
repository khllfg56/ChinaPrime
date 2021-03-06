package com.herokuapp.chinaprime;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.herokuapp.chinaprime.Adapters.AdapterCart;
import com.herokuapp.chinaprime.Objects.Item;

import java.util.ArrayList;


public class ShoppingCartActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private AdapterCart mAdapter;
    private ArrayList<Item> mCartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        this.setTitle("Cart");
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_cart);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //This is to grab items from main activity
        grabFromMainActivity();

        // specify an adapter (see also next example)
        mAdapter = new AdapterCart(this.mCartItems, this.getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping_cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item_home clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Made for demo reasons
    private void grabFromMainActivity() {
        mCartItems = MainActivity.mCartItems;
    }

}
