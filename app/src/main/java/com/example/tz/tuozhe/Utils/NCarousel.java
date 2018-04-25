package com.example.tz.tuozhe.Utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tz.tuozhe.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tz on 2018/3/24.
 */
public class NCarousel extends StaticPagerAdapter {

    private Context context;
    private List<String> image;

    public NCarousel(Context context,List<String> image){
        this.context=context;
        this.image=image;
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        List<Integer> Quesheng=new ArrayList<>();
        Quesheng.add(R.mipmap.ic_cover_3);
        ImageView view = new ImageView(container.getContext());
        Glide.with(context).load(image.get(position)).into(view);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    Intent intent = new Intent(mContext, WebViewActivity.class);
//                    intent.putExtra("title",data.get(position).getTitle());
//                    intent.putExtra("url",data.get(position).getShare_links());
//                    startActivity(intent);
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public int getCount() {
        return image.size();
    }

}


