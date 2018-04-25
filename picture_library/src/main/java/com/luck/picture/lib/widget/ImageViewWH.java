package com.luck.picture.lib.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ZC on 2017/10/30.
 */

public class ImageViewWH extends ImageView {

    public ImageViewWH(Context context) {
        super(context);
    }

    public ImageViewWH(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewWH(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
