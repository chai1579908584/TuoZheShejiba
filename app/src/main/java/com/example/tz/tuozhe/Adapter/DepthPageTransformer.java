package com.example.tz.tuozhe.Adapter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.tz.tuozhe.Core.LinkagePager;

/**
 * Created by Tz on 2018/3/23.
 */
public class DepthPageTransformer implements ViewPager.PageTransformer {
    public static final float MAX_SCALE = 1.0f;

    public static final float MIN_SCALE = 0.75f;

    public static final float MIN_ALPHA = 0.3f;

    @Override
    public void transformPage(View page, float position)
    {
        if (position < -1)
        {
            position = -1;
        }
        else if (position > 1)
        {
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        // 一个公式
        float scaleValue = MIN_SCALE + tempScale * slope;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);
        if (position > -1 && position < 1)
        {
            // 加渐变透明效果，中间的view完全不透明
            page.setAlpha((1 - MIN_ALPHA) * tempScale + MIN_ALPHA);
        }
        else
        {
            page.setAlpha(MIN_ALPHA);
        }

        if (Build.VERSION.SDK_INT < 19 && page.getParent() != null)
        {
            page.getParent().requestLayout();
        }
    }
}

