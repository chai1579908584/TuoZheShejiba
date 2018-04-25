package com.example.tz.tuozhe.Activity.Dynamic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
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
import com.example.tz.tuozhe.Adapter.New_Hot_Adapter;
import com.example.tz.tuozhe.Bean.New_Hot_Bean;
import com.example.tz.tuozhe.Bean.UserInfoModel;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tz on 2018/4/19.
 */
public class VeryNew extends Fragment {

    private RecyclerView dynamic_recycler;
    private SharedPreferences data;
    private SmartRefreshLayout toload;
    private static final int CENCELDYNAMICLIST=0;
    private static final int DYNAMICLIST=1;
    private static final int TOLOAD=2;
    private int page=1;
    private List<New_Hot_Bean.DataBean>  DATA=new ArrayList<>();
    private Gson g = new Gson();
    private List<New_Hot_Bean.DataBean> newdata;
    private New_Hot_Bean new_hot_bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_new_hot,null);
        initview(view);
        return view;
    }

    private void initview(View view) {
        data=getActivity().getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        dynamic_recycler=view.findViewById(R.id.dynamic_recycler);
        toload=view.findViewById(R.id.toload);
        toload.setEnableRefresh(true);
        toload.setEnableLoadmore(true);
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.black,R.color.white);
                return new ClassicsHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {

                return new ClassicsFooter(context).setDrawableArrowSize(20);
            }
        });
        toload.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page=1;
                getData();
            }
        });
        toload.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                toload();
            }
        });
        getData();
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        switch (msg.what)
        {
            case DYNAMICLIST:
                new_hot_bean = g.fromJson(msg.obj.toString(), New_Hot_Bean.class);
                newdata = new_hot_bean.getData();
                   DATA.clear();
                DATA.addAll(newdata);
                toload.finishRefresh();
                setAdapter();
                break;
            case TOLOAD:
                new_hot_bean = g.fromJson(msg.obj.toString(), New_Hot_Bean.class);
                newdata = new_hot_bean.getData();
                DATA.addAll(newdata);
                toload.finishLoadmore();
                break;
            case CENCELDYNAMICLIST:
                Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
                break;
        }

        }
    };

    private void setAdapter() {
        StaggeredGridLayoutManager sgl=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        dynamic_recycler.setLayoutManager(sgl);
        New_Hot_Adapter newHotAdapter=new New_Hot_Adapter(getActivity(),DATA,getActivity());
        dynamic_recycler.setAdapter(newHotAdapter);
    }

    @SuppressLint("LongLogTag")
    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=new StringRequest(UrlUtils.DYNAMIC_LIST + "?token=" + data.getString("token", "") + "&version=" + Version.PackageName(getActivity()) + "&page=" + page, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=DYNAMICLIST;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
               mHandler.sendEmptyMessage(CENCELDYNAMICLIST);
            }
        });
        requestQueue.add(stringRequest);
    }

    @SuppressLint("LongLogTag")
    private void toload() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=new StringRequest(UrlUtils.DYNAMIC_LIST + "?token=" + data.getString("token", "") + "&version=" + Version.PackageName(getActivity()) + "&page=" + page, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=TOLOAD;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(CENCELDYNAMICLIST);
            }
        });
        requestQueue.add(stringRequest);
    }
}

