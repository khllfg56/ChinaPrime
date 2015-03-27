package com.herokuapp.chinaprime;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.herokuapp.chinaprime.Adapters.AdapterMain;
import com.herokuapp.chinaprime.ClickListeners.DrawerItemClickListener;
import com.herokuapp.chinaprime.Fragments.CartFragment;
import com.herokuapp.chinaprime.Objects.Item;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private AdapterMain mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private String[] mMenuTitles;
    private String DEBUG = "MainActivity";

    public static ArrayList<Item> mItems;
    public static ArrayList<Integer> mSavedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_sysbar_menu_land_big);

        //addItems
        this.createItems();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new AdapterMain(this.mItems);
        mRecyclerView.setAdapter(mAdapter);

        //Setting up navigation drawer
        mMenuTitles = getResources().getStringArray(R.array.menu_options);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener(this));

        mDrawerList.setItemChecked(0, true);

        //setting up items lists
        mSavedItems = new ArrayList<Integer>();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } else if (id == 16908332) {
            Log.i(DEBUG, "Home Button pressed");
            openCloseDrawer();

            return true;
        } else if (id == R.id.cart) {
            Log.i(DEBUG, "Card Pressed");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
     * Open or close drawer
     *
     * @param
     */
    private void openCloseDrawer() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            this.mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            this.mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }

    /*
     * Selected drawer item
     *
     * @param position in drawer
     */
    public void selectItem(int position) {
        Log.i(DEBUG, "" + position);

        switch(position){
            case 1:
                // update the main content by replacing fragments
                Fragment fragment = new CartFragment();
                Bundle args = new Bundle();
                args.putInt(CartFragment.menu_number, position);
                fragment.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                break;

            case 2:


            default:

        }

        // update selected item_home and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mMenuTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    /********INTENTS TO NEW ACTIVITES*********/

    /*
     * starts intent 'ViewItemActivity'
     *
     * @param position of item
     */
    public void goToViewItem(int position) {
        Intent intent = new Intent(this, ViewItemActivity.class);
        if(position >= 0 && position < this.mItems.size()) {
            intent.putExtra("Position", position);
            this.startActivity(intent);
        }
    }

    public void goToShoppingCard() {
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        this.startActivity(intent);
    }

    /********DemoItems*************/

    /*
     * Manually Create Items
     */
    private void createItems() {
        this.mItems = new ArrayList<Item>();
        this.mItems.add(new Item("iwatch", R.drawable.iwatch, 350, 250));
        this.mItems.add(new Item("Hero GoPro", R.drawable.herogopro, 200, 100));
        for (int i = 0; i < 5; i++) {
            this.mItems.add(new Item("Item " + i, R.drawable.ic_launcher, 35, 22));
        }
    }
}

