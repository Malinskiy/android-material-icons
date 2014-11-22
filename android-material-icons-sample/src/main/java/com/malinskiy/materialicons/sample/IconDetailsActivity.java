package com.malinskiy.materialicons.sample;

import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.malinskiy.materialicons.IconDrawable;
import com.malinskiy.materialicons.Iconify;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_icon_details)
public class IconDetailsActivity extends ActionBarActivity {
    public static final String ARG_POSITION = "position";

    @Extra(ARG_POSITION)
    public int position;

    @ViewById(R.id.item_icon)
    public ImageView      iconView;
    @ViewById(R.id.item_text)
    public RobotoTextView nameView;

    @AfterViews
    public void setup() {
        Iconify.IconValue iconValue = Iconify.IconValue.values()[position];
        iconView.setImageDrawable(new IconDrawable(this, iconValue).sizeRes(R.dimen.icon_detailed_size).colorRes(R.color.primary_dark_material_light));
        nameView.setText(iconValue.name());
    }
}
