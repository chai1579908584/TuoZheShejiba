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
import com.example.tz.tuozhe.Adapter.Tripleton_Recycler;
import com.example.tz.tuozhe.Bean.Owner_ImageBean;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Url;

/**
 * Created by Tz on 2018/4/14.
 */
public class Owner_Image_Fragment extends Fragment {

    private RecyclerView image_recycler;
    private SharedPreferences data;
    private String token;
    private List<String> image=new ArrayList<>();
    private static final int IMAGE=1;
    private static final int IMAGE_LOSE=2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_owner_image,null);

        initview(view);
        return view;
    }

    private void initview(View view) {
        data=getActivity().getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        token = data.getString("token", "");
        image_recycler=view.findViewById(R.id.image_recycler);
        getData();
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        switch (msg.what)
        {
            case IMAGE:
                Gson g=new Gson();
                Owner_ImageBean owner_imageBean = g.fromJson(msg.obj.toString(), Owner_ImageBean.class);
                List<Owner_ImageBean.DataBean> data = owner_imageBean.getData();
                for (int i = 0; i < data.size(); i++) {
                    Owner_ImageBean.DataBean dataBean = data.get(i);
                    List<String> attaches = dataBean.getAttaches();
                    for (int i1 = 0; i1 < attaches.size(); i1++) {
                        image.add(attaches.get(i1));
                    }
                }
                setAdapter();
                break;
            case IMAGE_LOSE:
                Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
                break;
        }
        }
    };

    private void setAdapter() {
        StaggeredGridLayoutManager sgl = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        image_recycler.setLayoutManager(sgl);
        Tripleton_Recycler tr = new Tripleton_Recycler(getActivity(), image,getActivity());
        image_recycler.setAdapter(tr);
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringReques=new StringRequest(UrlUtils.USERIMAGE + "?version=" + Version.PackageName(getActivity()) + "&token=" + token + "&uid=" + data.getString("uid", "") + "&img=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=IMAGE;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
               mHandler.sendEmptyMessage(IMAGE_LOSE);
            }
        });
        requestQueue.add(stringReques);
    }

}

