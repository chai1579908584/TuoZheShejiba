package com.example.tz.tuozhe.Presenter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Bean.GuideBean;
import com.example.tz.tuozhe.View.GuideActivity;
import com.example.tz.tuozhe.View.GuideView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页 P 层逻辑
 * 通过 Volley 获取网络数据（Json串），Gson解析之后，得到需要的数据，装进集合，回传给 v 层
 */

public class GuidePresenterImpl implements GuidePresenter {

    private GuideView mGuideView;

    public GuidePresenterImpl(GuideActivity mGuideView) {
        this.mGuideView = mGuideView;
    }

    @Override
    public void onLoadPics(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(mGuideView.getContent());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                ArrayList<String> stringArrayList = new ArrayList<>();
                Gson gson = new Gson();
                //解析实体类，拿到图片的网址，存进集合，回传给 v 层
                GuideBean guideBean = gson.fromJson(s, GuideBean.class);
                List<GuideBean.InfoBean.GoodsBean> goods = guideBean.getInfo().getGoods();
                for (GuideBean.InfoBean.GoodsBean good : goods) {
                    stringArrayList.add(good.getThumb());
                }
                mGuideView.afterPics(true, null, stringArrayList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mGuideView.afterPics(false, volleyError.getMessage(), null);
            }
        });
        requestQueue.add(stringRequest);
    }
}
