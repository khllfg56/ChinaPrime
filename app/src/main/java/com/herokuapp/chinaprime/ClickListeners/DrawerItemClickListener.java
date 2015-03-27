package com.herokuapp.chinaprime.ClickListeners;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.herokuapp.chinaprime.MainActivity;

/**
 * Created by Andrew Cho on 3/27/2015.
 */
public class DrawerItemClickListener implements ListView.OnItemClickListener {
    MainActivity mMainActivity;

    public DrawerItemClickListener(Activity activity) {
        mMainActivity = (MainActivity) activity;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mMainActivity.selectItem(position);
    }
}
