package com.example.tyrehubv2.View;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ClickTextView extends TextView {
    public ClickTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Drawable drawable = getBackground();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                break;
            case MotionEvent.ACTION_CANCEL:
                drawable.clearColorFilter();
                break;
            case MotionEvent.ACTION_UP:
                drawable.clearColorFilter();
                break;
        }

        return super.onTouchEvent(event);
    }
}
