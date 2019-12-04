package com.example.tyrehubv2.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;




/**
 * Created by Developer on 2019/5/9.
 */

public class ColorFilterTextView extends TextView {


    public ColorFilterTextView(Context context) {
        this(context, null);
    }
    private boolean mUseWhite =false;



    public ColorFilterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchRect = new RectF();

    }

    public ColorFilterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchRect = new RectF();

    }

    int upX, upY;
    int widthSize, heightSize;
    private RectF mTouchRect;
    int left, top, right, bottom;
    boolean clickable = true;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mTouchRect.left = 0;
        mTouchRect.top = 0;
        mTouchRect.right = right - left;
        mTouchRect.bottom = bottom - top;

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

    }



    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!isEnabled()||!clickable){
            return true;
        }
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                ViewFilterUtils.setGrayFilter(this);
                break;
            case MotionEvent.ACTION_UP:
                upX = (int) event.getX();
                upY = (int) event.getY();
                if (mTouchRect.contains(upX, upY)) {
                    performClick();

                }
            case MotionEvent.ACTION_CANCEL:
               ViewFilterUtils.removeFilter(this);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

}
