package com.malinskiy.materialicons.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.malinskiy.materialicons.Iconify;
import com.malinskiy.materialicons.R;

public class IconTextView extends TextView {

    public IconTextView(Context context) {
        super(context);
        init(null);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        boolean hackyPreview = false;
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.IconTextView, 0, 0);
        try {
            hackyPreview = a.getBoolean(R.styleable.IconTextView_hacky_preview, false);
        } finally {
            a.recycle();
        }

        if (!isInEditMode())
            Iconify.addIcons(this);
        else if (hackyPreview) {
            Iconify.addIconsEditMode(this);
        } else {
            this.setText(this.getText());
        }
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(Iconify.compute(text), type);
    }

}
