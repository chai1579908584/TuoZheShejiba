package com.example.tz.tuozhe.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.DateUtils;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.example.tz.tuozhe.Utils.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Tz on 2018/4/18.
 */
public class CommentList_Recycler extends RecyclerView.Adapter<CommentList_Recycler.My> {


    private Context context;
    private List<String> image;
    private List<String> name;
    private List<String> time;
    private List<String> content;


    public CommentList_Recycler (Context context,List<String> image,List<String> name,List<String> time,List<String> content){
        this.context=context;
        this.image=image;
        this.name=name;
        this.time=time;
        this.content=content;
    }

    @Override
    public My onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.commentlist_recycler,null);
        return new My(view);
    }

    @Override
    public void onBindViewHolder(My holder, int position) {
        GlideUtil.displayRoundImage(context,image.get(position),holder.head_image,36);
        holder.name.setText(name.get(position));
        try {
            holder.time.setText(TimeUtils.Calculate(DateUtils.getDateFormat(time.get(position),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")),TimeUtils.getSystemTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.content.setText(content.get(position));
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    class My extends RecyclerView.ViewHolder {
        private ImageView head_image;
        private TextView name,time,content;

        public My(View itemView) {
            super(itemView);
            head_image=itemView.findViewById(R.id.head_image);
            name=itemView.findViewById(R.id.name);
            time=itemView.findViewById(R.id.time);
            content=itemView.findViewById(R.id.content);
        }
    }
}

