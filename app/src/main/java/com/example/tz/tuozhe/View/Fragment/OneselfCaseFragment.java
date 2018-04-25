package com.example.tz.tuozhe.View.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Adapter.Case_Recyclerview;
import com.example.tz.tuozhe.Bean.CaseStylistBean;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tz on 2018/4/16.
 */
public class OneselfCaseFragment extends Fragment {

    private RecyclerView image_recycler;
    private SharedPreferences data;
    private static final int STYLIST=1;
    private static final int STYLIST_LOSE=2;
    private List<String> image=new ArrayList<>();
    private List<String> title=new ArrayList<>();
    private List<String> label=new ArrayList<>();
    private List<String> share=new ArrayList<>();
    private List<String> check=new ArrayList<>();
    private List<String> id=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_owner_image,null);

        initview(view);
        return view;
    }

    private void initview(View view) {
        data=getActivity().getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        image_recycler=view.findViewById(R.id.image_recycler);

        getData();
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
          switch (msg.what)
          {
              case STYLIST:
                  Gson g=new Gson();
                  CaseStylistBean caseStylistBean = g.fromJson(msg.obj.toString(), CaseStylistBean.class);
                  CaseStylistBean.DataBean data = caseStylistBean.getData();
                  List<CaseStylistBean.DataBean.CaseBean> caseX = data.getCaseX();
                  for (int i = 0; i < caseX.size(); i++) {
                      image.add(caseX.get(i).getLogo());
                      title.add(caseX.get(i).getTitle());
                      label.add(caseX.get(i).getLabel());
                      share.add(caseX.get(i).getShare_links());
                      id.add(caseX.get(i).getId());
                      check.add("2");
                  }

                  setAdapter();
                  break;
              case STYLIST_LOSE:
                  break;
          }
        }
    };

    private void setAdapter() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        image_recycler.setLayoutManager(staggeredGridLayoutManager);
        Case_Recyclerview adapter=new Case_Recyclerview(getActivity(),image,title,label,share,id,check);
        image_recycler.setAdapter(adapter);
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringrequest=new StringRequest(UrlUtils.STYLIST+"?token="+data.getString("token","")+"&version="+ Version.PackageName(getActivity())+"&id="+data.getString("uid",""), new Response.Listener<String>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=STYLIST;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(STYLIST_LOSE);
            }
        });
        requestQueue.add(stringrequest);
    }


}

