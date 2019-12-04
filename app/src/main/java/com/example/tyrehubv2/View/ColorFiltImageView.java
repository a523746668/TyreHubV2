package com.example.tyrehubv2.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.annotation.Nullable;



/**
 * @ClassName: ThumbnailView
 * @Description: 点击时显示明暗变化(滤镜效果)的ImageView
 */
public class ColorFiltImageView extends ImageView {

	public ColorFiltImageView(Context context) {
		this(context, null);
	}

	public ColorFiltImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mTouchRect = new RectF();

	}

	public ColorFiltImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mTouchRect = new RectF();
	}

	protected int upX;
	protected int upY;
	int widthSize, heightSize;
	protected RectF mTouchRect;
	int left, top, right, bottom;
	public  boolean mIsSuperCanva=true;
	private boolean mHasAudio = true;

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
		 if(mIsSuperCanva){
			 super.onDraw(canvas);
		 }
	 	resetTouchRect();
	}

	protected void resetTouchRect() {
		mTouchRect.left = 0;
		mTouchRect.top = 0;
		mTouchRect.right = right - left;
		mTouchRect.bottom = bottom - top;
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if(!isClickable()) {
			return false;
		}
		switch (event.getActionMasked()) {
		case MotionEvent.ACTION_DOWN:
			// 在按下事件中设置滤镜
			ViewFilterUtils.setGrayFilter(this);

			break;
		case MotionEvent.ACTION_UP:
			if(mHasAudio){

			}
			upX = (int) event.getX();
			upY = (int) event.getY();
			//Log.v("-", "upX=" + upX + "||upY=" + upY);
			//Log.v("-", "widthSize=" + widthSize + "||heightSize=" + heightSize);
			//Log.v("-", "left=" + left + "||top=" + top + "||right=" + right + "||bottom=" + bottom);
			//Log.v("-", "right - left=" + (right - left) + "||bottom - top=" + (bottom - top));
			
			// 由于捕获了Touch事件，需要使用 performClick()方法手动触发Click事件
			// 判断ACTION_UP时候的坐标是否还在view的范围内，不在范围内不触发click事件
			if (mTouchRect.contains(upX, upY)) {
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

	public void setHasAudio(boolean hasAudio){
		mHasAudio = hasAudio;
	}

	public void setClickableWithOutAlpha(boolean clickable){
		super.setClickable(clickable);
		setEnabled(clickable);
		setFocusableInTouchMode(clickable);
		setAlpha(1.0f);
	}
	public void setClickable(boolean clickAble) {
		super.setClickable(clickAble);
		if(!clickAble) {
			setEnabled(false);
			setFocusableInTouchMode(false);
			setAlpha(0.5f);
		}else {
			setEnabled(true);
			setFocusableInTouchMode(true);
			setAlpha(1.0f);
		}
	}

	@Override
	public void setImageResource(int resId) {
		ViewFilterUtils.removeFilter(this);
		super.setImageResource(resId);
		ViewFilterUtils.removeFilter(this);
	}

	public void resetState()
	{
		ViewFilterUtils.removeFilter(this);
	}

	@Override
	public void setBackgroundResource(int resid) {
		ViewFilterUtils.removeFilter(this);
		super.setBackgroundResource(resid);
		ViewFilterUtils.removeFilter(this);
	}

	@Override
	public void setBackground(Drawable background) {
		ViewFilterUtils.removeFilter(this);
		super.setBackground(background);
		ViewFilterUtils.removeFilter(this);
	}

	@Override
	public void setBackgroundDrawable(Drawable background) {
		ViewFilterUtils.removeFilter(this);
		super.setBackgroundDrawable(background);
		ViewFilterUtils.removeFilter(this);
	}

	@Override
	public void setImageDrawable(@Nullable Drawable drawable) {
		ViewFilterUtils.removeFilter(this);
		super.setImageDrawable(drawable);
		ViewFilterUtils.removeFilter(this);
	}

}
