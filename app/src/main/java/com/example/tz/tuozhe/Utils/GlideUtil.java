package com.example.tz.tuozhe.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.tz.tuozhe.R;


/**
 * Created by NEU on 2017/10/30.
 */

public class GlideUtil {

    public static void displayImage(Context context,String imgUrl, ImageView imageView){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.picture)
                .error(R.drawable.picture)
                .priority(Priority.HIGH)
                .centerCrop();
        Glide.with(context).load(imgUrl).apply(options).into(imageView);
    }

    public static void displayImageDefalut(Context context,String imgUrl, ImageView imageView){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.picture)
                .error(R.drawable.picture)
                .priority(Priority.HIGH);
        Glide.with(context).load(imgUrl).apply(options).into(imageView);
    }

    public static void displayCircleImage (Context context,String path,ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.picture)
                .error(R.drawable.picture)
                .priority(Priority.HIGH)
                .transform(new MultiTransformation<>(new CenterCrop(),new GlideCircleTransform()));
        Glide.with(context).load(path).apply(options).into(imageView);
    }
    public static void displayRoundImage (Context context,String path,ImageView imageView,int radiusSize) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.picture)
                .error(R.drawable.picture)
                .priority(Priority.HIGH)
                .transform(new MultiTransformation<>(new CenterCrop(),new GlideRoundTransform(PxSpDpUtil.dip2px(context,radiusSize), 0)));//圆角处理
        Glide.with(context).load(path).apply(options).into(imageView);
    }

    public static void displayDiffRoundImage(Context context,String path,ImageView imageView,int radiusSize){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.picture)
                .error(R.drawable.picture)
                .priority(Priority.HIGH)
                .transform(new MultiTransformation<>(new CenterCrop(),new GlideRoundTransform( PxSpDpUtil.dip2px(context,radiusSize), 0,GlideRoundTransform.CornerType.TOP)));//圆角处理
        Glide.with(context).load(path).apply(options).into(imageView);
    }


}
