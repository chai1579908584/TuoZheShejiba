package com.example.tz.tuozhe.CustomView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.tz.tuozhe.Utils.SettingUtils;


/*
* 自定义ViewPager
* 变量 isCanScroll = 设置工具类（SettingUtils）里的变量 ISCANSCROLL
* 用来控制自定义的 IndexViewPager 是否可以滑动
* */

public class IndexViewPager extends ViewPager {

    private boolean isCanScroll = SettingUtils.ISCANSCROLL;

    public IndexViewPager(Context context) {
        super(context);
    }

    public IndexViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (isCanScroll) {
            return super.onTouchEvent(arg0);
        } else {
            return false;
        }

    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (isCanScroll) {
            return super.onInterceptTouchEvent(arg0);
        } else {
            return false;
        }

    }
}