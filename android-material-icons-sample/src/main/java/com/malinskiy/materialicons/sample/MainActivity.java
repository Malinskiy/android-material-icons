package com.malinskiy.materialicons.sample;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    @ViewById(R.id.recycler_icons)
    protected RecyclerView               recyclerView;
    private   RecyclerView.Adapter       adapter;
    private   RecyclerView.LayoutManager layoutManager;
    private   GestureDetectorCompat      gestureDetector;

    @AfterViews
    public void setupViews() {
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, getResources().getInteger(R.integer.icon_columns));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnItemTouchListener(this);

        adapter = new IconsAdapter();
        recyclerView.setAdapter(adapter);

        gestureDetector = new GestureDetectorCompat(this, new RecyclerViewOnGestureListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
            if(view == null) return false;

            int position = recyclerView.getChildLayoutPosition(view);

            MainActivity activity = MainActivity.this;


            View iconElement = view.findViewById(R.id.item_icon);

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity, iconElement, getResources().getString(R.string.transition_icon));
            ActivityCompat.startActivity(activity, IconDetailsActivity_.intent(activity).position(position).get(),
                                         options.toBundle());

            return true;
        }
    }
}