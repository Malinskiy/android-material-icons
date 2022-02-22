package com.malinskiy.materialicons.sample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.malinskiy.materialicons.IconDrawable;
import com.malinskiy.materialicons.Iconify;

public class IconDetailsActivity extends AppCompatActivity {
    public static final String ARG_POSITION = "position";

    public int position;

    public static Intent intent(MainActivity activity, int position) {
        Intent intent = new Intent(activity, IconDetailsActivity.class);
        intent.putExtra(ARG_POSITION, position);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_details);

        ImageView iconView = findViewById(R.id.item_icon);
        TextView nameView = findViewById(R.id.item_text);
        
        position = getIntent().getExtras().getInt(ARG_POSITION);
        Iconify.IconValue iconValue = Iconify.IconValue.values()[position];
        iconView.setImageDrawable(new IconDrawable(this, iconValue).sizeRes(R.dimen.icon_detailed_size).colorRes(R.color.primary_dark_material_light));
        nameView.setText(iconValue.name());
    }
}
