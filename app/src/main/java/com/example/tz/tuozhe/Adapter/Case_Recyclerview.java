package com.example.tz.tuozhe.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tz.tuozhe.Activity.Case.Case_ParticularsOwner;
import com.example.tz.tuozhe.R;

import java.util.List;

/**
 * Created by Tz on 2018/3/24.
 */
public class Case_Recyclerview extends RecyclerView.Adapter<Case_Recyclerview.My> {

    private Context context;
    private List<String> image;
    private List<String> title;
    private List<String> label;
    private List<String> share;
    private List<String> id;
    private List<String> check;
    public Case_Recyclerview(Context context,List<String> image,List<String> title,List<String> label,List<String> share,List<String> id,List<String> check){
        this.context=context;
        this.image=image;
        this.title=title;
        this.label=label;
        this.share=share;
        this.id=id;
        this.check=check;
    }

    @Override
    public My onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.case_recycler,null);
        return new My(view);
    }

    @Override
    public void onBindViewHolder(My holder, final int position) {
        Glide.with(context).load(image.get(position)).into(holder.case_image);
        holder.case_title.setText(title.get(position));
        holder.case_label.setText(label.get(position));
        holder.ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, Case_ParticularsOwner.class);
                intent.putExtra("html",share.get(position));
                intent.putExtra("id",id.get(position));
                intent.putExtra("check",check.get(position));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return image.size();
    }

    class My extends RecyclerView.ViewHolder {
        private ImageView case_image;
        private TextView  case_title;
        private TextView case_label;
        private LinearLayout ll_item;
        public My(View itemView) {
            super(itemView);
            case_image=itemView.findViewById(R.id.case_image);
            case_title=itemView.findViewById(R.id.case_title);
            case_label=itemView.findViewById(R.id.case_label);
            ll_item=itemView.findViewById(R.id.ll_item);
        }
    }
}

