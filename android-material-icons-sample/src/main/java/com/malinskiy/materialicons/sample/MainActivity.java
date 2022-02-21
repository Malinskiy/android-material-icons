package com.malinskiy.materialicons.sample;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
    protected RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_icons);
        setupViews();
    }

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
            if (view == null) return false;

            int position = recyclerView.getChildLayoutPosition(view);

            MainActivity activity = MainActivity.this;


            View iconElement = view.findViewById(R.id.item_icon);

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity, iconElement, getResources().getString(R.string.transition_icon));
            ActivityCompat.startActivity(activity, IconDetailsActivity.intent(activity, position),
                    options.toBundle());

            return true;
        }
    }
}
