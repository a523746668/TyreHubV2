package com.example.tyrehubv2.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;




/**
 * Created by limian on 2015/10/19.
 */
@SuppressLint("AppCompatCustomView")
public class ColorFiltButton extends Button {

    private boolean mCustomEnableControl = true;//设置enable，不用系统的

    public ColorFiltButton(Context context) {
        this(context, null);
    }

    public ColorFiltButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchRect = new RectF();
    }

    public ColorFiltButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchRect = new RectF();
    }

    int upX, upY;
    int widthSize, heightSize;
    private RectF mTouchRect;
    int left, top, right, bottom;

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



    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(!isEnabled()) {
            return true;
        }

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                // 在按下事件中设置滤镜
                ViewFilterUtils.setGrayFilter(this);

                break;
            case MotionEvent.ACTION_UP:
                upX = (int) event.getX();
                upY = (int) event.getY();

                // 由于捕获了Touch事件，需要使用 performClick()方法手动触发Click事件
                // 判断ACTION_UP时候的坐标是否还在view的范围内，不在范围内不触发click事件
                if (mTouchRect.contains(upX, upY)&&isClickable()) {
                    performClick();
                }
            case MotionEvent.ACTION_CANCEL:
                // 在CANCEL和UP事件中清除滤镜
                ViewFilterUtils.removeFilter(this);

                break;
            default:
                break;
        }
        return true;
    }

    public void setCanClickable(boolean clickAble) {
        super.setClickable(clickAble);
        setEnabled(clickAble);
        setFocusableInTouchMode(clickAble);
        if(!clickAble) {
            setAlpha(0.5f);
        }else {
            setAlpha(1.0f);
        }
    }

    /**
     * 自定义enable，防止系统干扰设置
     * @param enable
     */
    public void setCustomEnable(boolean enable) {
        setEnabled(enable);
        if(enable) {
            setAlpha(1.f);
        }else {
            setAlpha(0.5f);
        }
        this.mCustomEnableControl = enable;
    }

    //工程中尽量不用这个setEnable控制View的enable
    @Override
    public void setEnabled(boolean enabled) {
        mCustomEnableControl = false;
        super.setEnabled(enabled);
    }
}
