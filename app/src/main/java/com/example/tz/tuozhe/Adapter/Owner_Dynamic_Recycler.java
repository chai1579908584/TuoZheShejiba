package com.example.tz.tuozhe.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.DateUtils;
import com.example.tz.tuozhe.Utils.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tz on 2018/4/14.
 */
public class Owner_Dynamic_Recycler extends RecyclerView.Adapter<Owner_Dynamic_Recycler.My>{

    private Context context;
    private List<String> posts_id;
    private List<String> title;
    private List<String> content;
    private List<String> like_count;
    private List<String> commemt_count;
    private List<String> view_count;
    private List<String> address;
    private List<String> created_uid;
    private List<String> created_at;
    private List<List> attaches;
    private List<String> collect;
    private List<String> is_lick;
    private Activity activity;

    public Owner_Dynamic_Recycler(Context context,List<String> posts_id,List<String> title,List<String> content,List<String> like_count,
                                  List<String> commemt_count,List<String> view_count,List<String> address,List<String> created_uid,
                                  List<String> created_at,List<List> attaches, List<String> collect, List<String> is_lick, Activity activity){
        this.context=context;
        this.posts_id=posts_id;
        this.title=title;
        this.content=content;
        this.like_count=like_count;
        this.commemt_count=commemt_count;
        this.view_count=view_count;
        this.address=address;
        this.created_uid=created_uid;
        this.created_at=created_at;
        this.attaches=attaches;
        this.collect=collect;
        this.is_lick=is_lick;
        this.activity=activity;
    }
    @Override
    public My onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.owner_dynamic_recycler,null);
        return new My(view);
    }

    @Override
    public void onBindViewHolder(My holder, int position) {
        holder.one_image.setVisibility(View.VISIBLE);
        holder.recycler_.setVisibility(View.VISIBLE);
        holder.two_ll_box.setVisibility(View.VISIBLE);
        try {
            holder.time.setText(TimeUtils.Calculate(DateUtils.getDateFormat(created_at.get(position),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")),TimeUtils.getSystemTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.message.setText(content.get(position));
        holder.location.setText(address.get(position));
        holder.comment.setText(commemt_count.get(position));
        holder.praise.setText(like_count.get(position));

        if (attaches.get(position)!=null) {
            if (attaches.get(position).size() == 1) {
                Glide.with(context).load(attaches.get(position).get(0)).into(holder.one_image);
                holder.recycler_.setVisibility(View.GONE);
                holder.two_ll_box.setVisibility(View.GONE);
            } else if (attaches.get(position).size() == 2) {
                Glide.with(context).load(attaches.get(position).get(0)).into(holder.box_one);
                Glide.with(context).load(attaches.get(position).get(1)).into(holder.box_two);
                holder.one_image.setVisibility(View.GONE);
                holder.two_ll_box.setVisibility(View.GONE);
            } else if (attaches.get(position).size() >= 3) {
                StaggeredGridLayoutManager sgl = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                holder.recycler_.setLayoutManager(sgl);
                Tripleton_Recycler tr = new Tripleton_Recycler(context, attaches.get(position),activity);
                holder.recycler_.setAdapter(tr);
            }
        }else {
            holder.one_image.setVisibility(View.GONE);
            holder.recycler_.setVisibility(View.GONE);
            holder.two_ll_box.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return created_uid.size();
    }

    class My extends RecyclerView.ViewHolder {

        private TextView time,message,location,comment,praise;
        private ImageView one_image,box_one,box_two,share;
        private LinearLayout two_ll_box;
        private RecyclerView recycler_;
        public My(View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.time);
            message=itemView.findViewById(R.id.message);
            location=itemView.findViewById(R.id.location);
            comment=itemView.findViewById(R.id.comment);
            praise=itemView.findViewById(R.id.praise);
            one_image=itemView.findViewById(R.id.one_image);
            box_one=itemView.findViewById(R.id.box_one);
            box_two=itemView.findViewById(R.id.box_two);
            share=itemView.findViewById(R.id.share);
            two_ll_box=itemView.findViewById(R.id.two_ll_box);
            recycler_=itemView.findViewById(R.id.recycler_);

        }
    }
}

