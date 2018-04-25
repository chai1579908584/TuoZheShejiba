package com.example.tz.tuozhe.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Picture;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Bean.New_Hot_Bean;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.DateUtils;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.example.tz.tuozhe.Utils.TimeUtils;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tz on 2018/4/19.
 */
public class New_Hot_Adapter extends XRecyclerView.Adapter<New_Hot_Adapter.My> {

    private Context context;
    private List<New_Hot_Bean.DataBean> newdata;
    private SharedPreferences data;
    private static final int MISTAKE=0;
    private static final int ATTENTION=1;
    private String uid;
    private int like_count;
    private String posts_id;
    private List<String> sub=new ArrayList<>();
    private List<String> subc=new ArrayList<>();
    private Activity activity;
    private List<LocalMedia> localMedias=new ArrayList<>();


    public New_Hot_Adapter(Context context, List<New_Hot_Bean.DataBean> newdata, Activity activity){
        this.context=context;
        this.newdata=newdata;
        this.activity=activity;
    }

    @Override
    public My onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_recyclerview,null);
        
        return new My(view);
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
         switch (msg.what)
         {
             case ATTENTION:
                 try {
                     JSONObject json=new JSONObject(msg.obj.toString());
                     String message = json.getString("message");
                     Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
                 break;
             case MISTAKE:
                 Toast.makeText(context, "网络错误", Toast.LENGTH_SHORT).show();
                 break;
         }
        }
    };

    @Override
    public void onBindViewHolder(final My holder, final int position) {
        sub.clear();
        subc.clear();
        for (int i = 0; i < newdata.size(); i++) {
            sub.add(newdata.get(i).getCreated_user().getFollow());
            subc.add(newdata.get(i).getIs_like());
        }
        like_count= Integer.parseInt(newdata.get(position).getLike_count());
        data=context.getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        holder.rl_image_box.setVisibility(View.VISIBLE);
        holder.one_image.setVisibility(View.VISIBLE);
        holder.two_ll_box.setVisibility(View.VISIBLE);
        holder.recycler.setVisibility(View.VISIBLE);
        GlideUtil.displayRoundImage(context,newdata.get(position).getCreated_user().getAvatar(),holder.head_image,40);
        holder.user_name.setText(newdata.get(position).getCreated_user().getNick_name());
        try {
            holder.time_text.setText(TimeUtils.Calculate(DateUtils.getDateFormat(newdata.get(position).getCreated_at(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")),TimeUtils.getSystemTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.message_text.setText(newdata.get(position).getContent());
//        if (sub.get(position).equals("1"))
//        {
//                holder.attention_button.setChecked(true);
//        }
//        holder.attention_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (sub.get(position).equals("1"))
//                {
//                    uid=newdata.get(position).getCreated_uid();
//                    Cencel();
//                   sub.set(position,"2");
//                }else if (sub.get(position).equals("2")){
//                    uid=newdata.get(position).getCreated_uid();
//                    Attention();
//                    sub.set(position,"1");
//                }
//            }
//        });
        if (newdata.get(position).getAttaches().isEmpty())
        {
            holder.rl_image_box.setVisibility(View.GONE);
        }else if (newdata.get(position).getAttaches().size()==1)
        {
            GlideUtil.displayRoundImage(context,newdata.get(position).getAttaches().get(0),holder.one_image,0);
            holder.two_ll_box.setVisibility(View.GONE);
            holder.recycler.setVisibility(View.GONE);
        }else if (newdata.get(position).getAttaches().size()==2)
        {
            GlideUtil.displayRoundImage(context,newdata.get(position).getAttaches().get(0),holder.box_one,0);
            GlideUtil.displayRoundImage(context,newdata.get(position).getAttaches().get(1),holder.box_two,0);
            holder.one_image.setVisibility(View.GONE);
            holder.recycler.setVisibility(View.GONE);
        } else if (newdata.get(position).getAttaches().size()>=3) {
            holder.recycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
            Tripleton_Recycler tr = new Tripleton_Recycler(context, newdata.get(position).getAttaches(),activity);
            holder.recycler.setAdapter(tr);
            holder.one_image.setVisibility(View.GONE);
            holder.two_ll_box.setVisibility(View.GONE);
        }

        holder.one_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localMedias.clear();
                for (String imageUrl:newdata.get(position).getAttaches())
                {
                    localMedias.add(new LocalMedia(imageUrl,0,0,"image/jpeg"));
                }
                PictureSelector.create(activity).externalPicturePreview(0,localMedias);
            }
        });

        holder.box_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localMedias.clear();
                for (String imageUrl:newdata.get(position).getAttaches())
                {
                    localMedias.add(new LocalMedia(imageUrl,0,0,"image/jpeg"));
                }
                PictureSelector.create(activity).externalPicturePreview(0,localMedias);
            }
        });

        holder.box_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localMedias.clear();
                for (String imageUrl:newdata.get(position).getAttaches())
                {
                    localMedias.add(new LocalMedia(imageUrl,0,0,"image/jpeg"));
                }
                PictureSelector.create(activity).externalPicturePreview(1,localMedias);
            }
        });

        holder.location.setText(newdata.get(position).getAddress());
      //  Log.e("ssssssssssssssssss",like_count+"");
        holder.like_text.setText(like_count+"");
//        if (subc.get(position).equals("0"))
//        {
//            holder.like_image.setChecked(false);
//        }else if(subc.get(position).equals("1")){
//            holder.like_image.setChecked(true);
//        }
//        holder.like_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("sssssssssssssssssssss",subc.get(position)+"");
//                Log.e("ssssssssssssssssss",like_count+"");
//                if (subc.get(position).equals("0"))
//                { posts_id=newdata.get(position).getPosts_id();
//                    like();
//                    like_count++;
//                    holder.like_text.setText(like_count+"");
//                    subc.set(position,"1");
//                    holder.like_image.setChecked(true);
//                }else if(subc.get(position).equals("1"))
//                { posts_id=newdata.get(position).getPosts_id();
//                    cancel();
//                    like_count--;
//                    holder.like_text.setText(like_count+"");
//                    subc.set(position,"0");
//                    holder.like_image.setChecked(false);
//                }
//                Log.e("sssssssssssssssss",subc.get(position)+"");
//                Log.e("sssssssssssssssss1",like_count+"");
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return newdata.size();
    }

    @SuppressLint("LongLogTag")
    private void like() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(UrlUtils.LIKE + "?token=" + data.getString("token","") + "&version=" + Version.PackageName(context) + "&type=2" + "&posts_id=" + posts_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=ATTENTION;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }
    @SuppressLint("LongLogTag")
    private void cancel() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(UrlUtils.CENCEL_LIKE + "?token=" + data.getString("token","") + "&version=" + Version.PackageName(context) + "&type=2" + "&posts_id=" + posts_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=ATTENTION;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }
    @SuppressLint("LongLogTag")
    private void Attention() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(UrlUtils.ATTENTION + "?token=" + data.getString("token", "") + "&version=" + Version.PackageName(context) + "&follow_id=" + uid, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.what=ATTENTION;
                message.obj=s;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
               mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }
    @SuppressLint("LongLogTag")
    private void Cencel() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(UrlUtils.CENCEL_ATTENTION + "?token=" + data.getString("token", "") + "&version=" + Version.PackageName(context) + "&follow_id=" + uid, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.what=ATTENTION;
                message.obj=s;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }

    class My extends XRecyclerView.ViewHolder {
        private ImageView head_image,one_image,box_one,box_two,share;
        private TextView user_name,time_text,message_text,location,comment,like_text;
        private RadioButton attention_button,like_image;
        private RelativeLayout rl_image_box;
        private LinearLayout two_ll_box;
        private RecyclerView recycler;
        public My(View itemView) {
            super(itemView);
            head_image=itemView.findViewById(R.id.head_image);
            one_image=itemView.findViewById(R.id.one_image);
            box_one=itemView.findViewById(R.id.box_one);
            box_two=itemView.findViewById(R.id.box_two);
            share=itemView.findViewById(R.id.share);
            user_name=itemView.findViewById(R.id.user_name);
            time_text=itemView.findViewById(R.id.time_text);
            message_text=itemView.findViewById(R.id.message_text);
            location=itemView.findViewById(R.id.location);
            attention_button=itemView.findViewById(R.id.attention_button);
            rl_image_box=itemView.findViewById(R.id.rl_image_box);
            two_ll_box=itemView.findViewById(R.id.two_ll_box);
            comment=itemView.findViewById(R.id.comment);
            like_image=itemView.findViewById(R.id.like_image);
            like_text=itemView.findViewById(R.id.like_text);
            recycler=itemView.findViewById(R.id.recycler);
        }
    }
}

