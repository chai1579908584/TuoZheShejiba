package com.example.tz.tuozhe.View.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Adapter.Owner_Dynamic_Recycler;
import com.example.tz.tuozhe.Bean.Owner_DanamicBean;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.UserManager;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tz on 2018/4/14.
 */
public class Owner_Dynamic_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private UserManager user=new UserManager(getActivity());
    private SharedPreferences data;
    private String token;
    private static final int DATASUCCESS=1;
    private static final int LOSE=0;
    private List<String> posts_id=new ArrayList<>();
    private List<String> title=new ArrayList<>();
    private List<String> content=new ArrayList<>();
    private List<String> like_count=new ArrayList<>();
    private List<String> commemt_count=new ArrayList<>();
    private List<String> view_count=new ArrayList<>();
    private List<String> address=new ArrayList<>();
    private List<String> created_uid=new ArrayList<>();
    private List<String> created_at=new ArrayList<>();
    private List<List> attaches=new ArrayList<>();
    private List<String> collect=new ArrayList<>();
    private List<String> is_lick=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_owner_dynamic,null);

        initview(view);
        return view;
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        switch (msg.what)
        {
            case DATASUCCESS:
                Gson g=new Gson();
                Owner_DanamicBean owner_danamicBean = g.fromJson(msg.obj.toString(), Owner_DanamicBean.class);
                Owner_DanamicBean.DataBean data = owner_danamicBean.getData();
                List<Owner_DanamicBean.DataBean.MyPostsBean> my_posts = data.getMy_posts();
                for (int i = 0; i < my_posts.size(); i++) {
                    Owner_DanamicBean.DataBean.MyPostsBean myPostsBean = my_posts.get(i);
                    posts_id.add(myPostsBean.getPosts_id());
                    title.add(myPostsBean.getTitle());
                    content.add(myPostsBean.getContent());
                    like_count.add(myPostsBean.getLike_count());
                    commemt_count.add(myPostsBean.getComment_count());
                    view_count.add(myPostsBean.getView_count());
                    address.add(myPostsBean.getAddress());
                    created_uid.add(myPostsBean.getCreated_uid());
                    created_at.add(myPostsBean.getCreated_at());
                    attaches.add(myPostsBean.getAttaches());
                    collect.add(myPostsBean.getCollect());
                    is_lick.add(myPostsBean.getIs_like());
                }
                setAdapter();
                break;
            case LOSE:

                break;

        }

        }
    };

    private void setAdapter() {
        StaggeredGridLayoutManager sgl=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sgl);
        Owner_Dynamic_Recycler odr=new Owner_Dynamic_Recycler(getActivity(),posts_id,title,content,like_count,commemt_count,view_count,address,created_uid,created_at,attaches,collect,is_lick,getActivity());
        recyclerView.setAdapter(odr);
    }

    private void initview(View view) {
        data=getActivity().getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        token = data.getString("token", "");
        recyclerView=view.findViewById(R.id.dynamic_recycler);

        getData();
    }

    private void getData(){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=new StringRequest(UrlUtils.USERHOME + "?version=" + Version.PackageName(getActivity()) + "&token=" + token + "&uid=" + data.getString("uid", ""), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=DATASUCCESS;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(LOSE);
            }
        });
        requestQueue.add(stringRequest);
    }
}

