package com.example.tz.tuozhe.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tz on 2018/4/14.
 */
public class Tripleton_Recycler extends RecyclerView.Adapter<Tripleton_Recycler.My> {

    private Context context;
    private List<String> image_url=new ArrayList<>();
    private Activity activity;
    private List<LocalMedia> localMedias=new ArrayList<>();
    public Tripleton_Recycler(Context context,List<String> image_url, Activity activity){
        this.context=context;
        this.image_url=image_url;
        this.activity=activity;
    }



    @Override
    public My onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_recycler, parent,false);
        return new My(view);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(My holder, final int position) {
        GlideUtil.displayRoundImage(context,image_url.get(position),holder.image,0);
        localMedias.clear();
        for (String imageUrl:image_url)
        {
            localMedias.add(new LocalMedia(imageUrl,0,0,"image/jpeg"));
        }

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(activity).externalPicturePreview(position,localMedias);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image_url.size();
    }

    class My extends RecyclerView.ViewHolder {
        private ImageView image;
        public My(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
        }
    }
}

