package com.example.tz.tuozhe.Utils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.View.Fragment.HomePageFragment;

import java.util.List;

/**
 * Created by Tz on 2018/3/24.
 */
public class MyPagerAdapter extends PagerAdapter {
    private HomePageFragment.OnClickItemListener onClickItemListener;
    private List<String> image_list;
    private Context context;

    public MyPagerAdapter(Context context, List<String> image_list) {
        this.image_list = image_list;
        this.context = context;
    }

    public void setOnClickItemListener(HomePageFragment.OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final int index = position % image_list.size();

        View view = LayoutInflater.from(context).inflate(R.layout.item_cover, null);
        ImageView imageView =  view.findViewById(R.id.image_cover);
        Glide.with(context).load(image_list.get(index)).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickItemListener != null) {
                    onClickItemListener.onClickItem(index);
                }
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
    }


}
