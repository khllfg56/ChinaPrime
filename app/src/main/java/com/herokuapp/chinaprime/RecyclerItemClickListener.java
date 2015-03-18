package com.herokuapp.chinaprime;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Andrew Cho on 2/2/2015.
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
        mListener = listener;
    }

    /*
    * When Gesture detected, it intercepts and finds what view in recyclerView is used.
    * It then detects if there is a velocity to determine if item was swiped
    * If swiped, it will move to the deck
    * If clicked, it will show preview
    */
    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        final int action = e.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.i("OnTouchIntercept", "Single Tap");
                mListener.onItemClick(childView, view.getChildPosition(childView));
                return true;
        }
        return false;
    }

    @Override public void onTouchEvent(RecyclerView view, MotionEvent e) {  }

}