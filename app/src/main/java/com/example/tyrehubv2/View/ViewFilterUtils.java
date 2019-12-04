package com.example.tyrehubv2.View;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class ViewFilterUtils {

	/**
	 * 设置灰度滤镜
	 */
	public static void setGrayFilter(ImageView view) {
		// 先获取设置的src图片
		Drawable drawable = view.getDrawable();
		// 当src图片为Null，获取背景图片
		if (drawable == null) {
			drawable = view.getBackground();
		}
		if (drawable != null) {
			// 设置滤镜
			drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);

		}
		//view.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
	}

	/**
	 * 清除滤镜
	 */
	public static void removeFilter(ImageView view) {
		// 先获取设置的src图片
		Drawable drawable = view.getDrawable();
		// 当src图片为Null，获取背景图片
		if (drawable == null) {
			drawable = view.getBackground();
		}
		if (drawable != null) {
			// 清除滤镜
			drawable.clearColorFilter();
		}
	}

	/**
	 * 设置灰度滤镜
	 */
	public static void setGrayFilter(View view) {
		setFilter(view, Color.GRAY);
	}

	public static void setWhiteFilter(View view) {
		setFilter(view, Color.WHITE);
	}

	public static void setFilter(View view, int color) {
		Drawable drawable = view.getBackground();
		if (drawable != null) {
			// 设置滤镜

			//in main class
			PorterDuffColorFilter greenFilter =
					new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
           drawable.setColorFilter(greenFilter);
		}

	}

	/**
	 * 清除滤镜
	 */
	public static void removeFilter(View view) {
		Drawable drawable = view.getBackground();
		if (drawable != null) {
			// 清除滤镜
			drawable.clearColorFilter();
		}
	}

}
