package com.example.tz.tuozhe.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Tz on 2018/3/23.
 */
public class ViewPagerAdapter extends PagerAdapter{

    private Context mContext;
    private List<String> mImageIds;


    public ViewPagerAdapter(Context context, List<String> imageIds) {
        this.mContext = context;
        this.mImageIds = imageIds;
    }

    @Override
    public int getCount() {
        return this.mImageIds.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ImageView image=new ImageView(mContext);
        Glide.with(mContext).load(mImageIds.get(position)).into(image);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        image.setPadding(200, 80, 200, 80);
        ((ViewPager) container).addView(image);
        return image;
    }
}

