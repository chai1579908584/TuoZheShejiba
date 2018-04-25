package com.example.tz.tuozhe.View.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.tz.tuozhe.Adapter.Case_Recyclerview;
import com.example.tz.tuozhe.Bean.Banner_shouye;
import com.example.tz.tuozhe.Bean.CaseBean;
import com.example.tz.tuozhe.Bean.GatherBean;
import com.example.tz.tuozhe.Bean.Login;
import com.example.tz.tuozhe.Bean.StylistBean;
import com.example.tz.tuozhe.Common.BaseFragment;
import com.example.tz.tuozhe.Core.CoverFlow;
import com.example.tz.tuozhe.Core.PageItemClickListener;
import com.example.tz.tuozhe.Core.PagerContainer;
import com.example.tz.tuozhe.HomeActivity.CircleActivity;
import com.example.tz.tuozhe.Login.LoginActivity;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.DateUtils;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.example.tz.tuozhe.Utils.LazyScrollView;
import com.example.tz.tuozhe.Utils.MyPagerAdapter;
import com.example.tz.tuozhe.Utils.NCarousel;
import com.example.tz.tuozhe.Utils.TimeUtils;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.UserManager;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 主页面的第一个碎片布局
 */

public class HomePageFragment extends BaseFragment implements View.OnClickListener {



    private TextView stylist_xuhao,text_1,text_2,text_title1,text_title2,text_time1,text_time2,text_collect1,text_collect2;
    private ImageView video_1,video_2,essay_image1,essay_image2;
    private RelativeLayout rr_video1,rr_video2,ll_essay1,ll_essay2;
    private List<String> image=new ArrayList<>();
    private RollPagerView banner_rollviewpager;
    private List<String> contents=new ArrayList<>();
    private static final int BANNER=1;
    private static final int BANNER_LOSE=2;
    private static final int LIST=3;
    private static final int LIST_LOSE=4;
    private static final int STYLIST=5;
    private static final int STYLIST_LOSE=6;
    private static final int CASE=7;
    private static final int CASE_LOSE=8;
    private static final int CASE_JIAZAI=9;
    private static final int CASE_JIAZAI_LOSE=10;
    private static final int TOKEN_LOSE=11;
    private static final int VIDEO_LIST=12;
    private SharedPreferences data;
    private List<String> image_list=new ArrayList<>();
    private List<String> name_list=new ArrayList<>();
    private   Gson g=new Gson();
    private View view;
    private  MyPagerAdapter myPagerAdapter;
    private  String token;
    private int page=1;
    private List<String> image_recycler=new ArrayList<>();
    private List<String> title_recycler=new ArrayList<>();
    private List<String> label_recycler=new ArrayList<>();
    private List<String> share_recycler=new ArrayList<>();
    private List<String> id=new ArrayList<>();
    private List<String> check=new ArrayList<>();
    private RecyclerView case_recycler;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LazyScrollView scrollview;
    private EditText find_edittext;
    private ImageView find_imageview;
    private ArrayAdapter<String> adapter;
    private List<String> spinner=new ArrayList<>();
    private TextView find_text;
    private int number=1;
    private PopupWindow popupWindow;
    private RelativeLayout searchbox;
    private TextView case_text,article_text,stylist_text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_home, null);
         initview(view);

        return view;
    }

    public void initview(View view){
        spinner.add("案例");
        spinner.add("文章");
        spinner.add("设计师");
        find_text=view.findViewById(R.id.find_text);
        find_edittext=view.findViewById(R.id.find_edit);
        find_imageview=view.findViewById(R.id.find_image);

        find_imageview.setOnClickListener(this);
        find_text.setOnClickListener(this);

        searchbox=view.findViewById(R.id.Searchbox);

        stylist_xuhao=  view.findViewById(R.id.stylist_xuhao);
        banner_rollviewpager=view.findViewById(R.id.banner_rollviewpager);
        data=getActivity().getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        token = data.getString("token", "");

        text_1=view.findViewById(R.id.text_1);
        text_2=view.findViewById(R.id.text_2);
        video_1=view.findViewById(R.id.video_1);
        video_2=view.findViewById(R.id.video_2);
        rr_video1=view.findViewById(R.id.rr_video1);
        rr_video2=view.findViewById(R.id.rr_video2);

        text_title1=view.findViewById(R.id.text_title1);
        text_title2=view.findViewById(R.id.text_title2);
        text_time1=view.findViewById(R.id.text_time1);
        text_time2=view.findViewById(R.id.text_time2);
        text_collect1=view.findViewById(R.id.text_collect1);
        text_collect2=view.findViewById(R.id.text_collect2);
        essay_image1=view.findViewById(R.id.essay_image1);
        essay_image2=view.findViewById(R.id.essay_image2);

        case_recycler=view.findViewById(R.id.case_recycler);

        swipeRefreshLayout=view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        //改变加载显示的颜色
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.RED);
        //设置初始时的大小
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);

        //设置向下拉多少出现刷新
        swipeRefreshLayout.setDistanceToTriggerSync(100);
        //设置刷新出现的位置
        swipeRefreshLayout.setProgressViewEndTarget(false, 200);

        scrollview=view.findViewById(R.id.scrollview);
        scrollview.getView();

        Banner();
        getListData();
        getStylistData();
        getCase();
    }

    private Handler mHandler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case BANNER:
                    Banner_shouye banner_shouye = g.fromJson(msg.obj.toString(), Banner_shouye.class);
                    List<Banner_shouye.DataBean> banner = banner_shouye.getData();
                    for (int i = 0; i < banner.size(); i++) {
                        image.add(banner.get(i).getLogo());
                        contents.add(banner.get(i).getShare_links());
                    }
                    setImage();
                break;
                case BANNER_LOSE:
                    Toast.makeText(getActivity(), R.string.network, Toast.LENGTH_SHORT).show();
                    break;

                case LIST:
                    GatherBean caseBean = g.fromJson(msg.obj.toString(),GatherBean.class);
                    GatherBean.DataBean data = caseBean.getData();
//                    List<GatherBean.DataBean.CaseBean> caseX = data.getCaseX();
//                    text_demo1.setText(caseX.get(0).getTitle());
//                    text_demo2.setText(caseX.get(1).getTitle());
//                    Glide.with(getActivity()).load(caseX.get(0).getLogo()).into(demo_1);
//                    Glide.with(getActivity()).load(caseX.get(1).getLogo()).into(demo_2);

                    List<GatherBean.DataBean.ArticleBean> article = data.getArticle();
                    text_title1.setText(article.get(0).getTitle());
                    text_title2.setText(article.get(1).getTitle());
                    try {
                        text_time1.setText(TimeUtils.Calculate(DateUtils.getDateFormat(article.get(0).getCreatime(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")),TimeUtils.getSystemTime()));
                        text_time2.setText(TimeUtils.Calculate(DateUtils.getDateFormat(article.get(1).getCreatime(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")),TimeUtils.getSystemTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    text_collect1.setText(article.get(0).getLike_number()+"人收藏");
                    text_collect2.setText(article.get(1).getLike_number()+"人收藏");
                    Glide.with(getActivity()).load(article.get(0).getLogo()).into(essay_image1);
                    Glide.with(getActivity()).load(article.get(1).getLogo()).into(essay_image2);
                    GlideUtil.displayRoundImage(getActivity(),data.getVideo().get(0).getLogo(),video_1,0);
                    text_1.setText(data.getVideo().get(0).getTitle());
                    GlideUtil.displayRoundImage(getActivity(),data.getVideo().get(1).getLogo(),video_2,0);
                    text_2.setText(data.getVideo().get(1).getTitle());
                    break;
                case LIST_LOSE:
                    Toast.makeText(getActivity(), R.string.network, Toast.LENGTH_SHORT).show();
                    break;
                case STYLIST:
                    StylistBean stylistBean = g.fromJson(msg.obj.toString(), StylistBean.class);
                    StylistBean.DataBean data1 = stylistBean.getData();
                    List<StylistBean.DataBean.DisplayBean> display = data1.getDisplay();
                    image_list.clear();
                    name_list.clear();
                        for (int i = 0; i < display.size(); i++) {
                            image_list.add(display.get(i).getAvatar());
                            name_list.add(display.get(i).getNick_name());
                    }
                    stylist_xuhao.setText(name_list.get(0));
                    //ImageShow(view);
                    break;
                case STYLIST_LOSE:
                    Toast.makeText(getActivity(), R.string.network, Toast.LENGTH_SHORT).show();
                    break;
                case CASE:
                    CaseBean caseList = g.fromJson(msg.obj.toString(), CaseBean.class);
                    List<CaseBean.DataBean> data2 = caseList.getData();
                    image_recycler.clear();
                    title_recycler.clear();
                    share_recycler.clear();
                    for (int i = 0; i < data2.size(); i++) {
                        image_recycler.add(data2.get(i).getLogo());
                        title_recycler.add(data2.get(i).getTitle());
                        share_recycler.add(data2.get(i).getShare_links());
                        if (data2.get(i)==null) {
                            label_recycler.add(" ");
                        }else {
                            label_recycler.add(data2.get(i).getLabel());
                        }
                        id.add(data2.get(i).getId());
                        check.add(data2.get(i).getCheck());
                    }
                    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    });
                    setAdapter();
                    break;
                case CASE_LOSE:
                    Toast.makeText(getActivity(), R.string.network, Toast.LENGTH_SHORT).show();
                    break;
                case CASE_JIAZAI:
                    CaseBean caseList1 = g.fromJson(msg.obj.toString(), CaseBean.class);
                    List<CaseBean.DataBean> data3 = caseList1.getData();
                    for (int i = 0; i < data3.size(); i++) {
                        image_recycler.add(data3.get(i).getLogo());
                        title_recycler.add(data3.get(i).getTitle());
                        if (data3.get(i)==null) {
                            label_recycler.add(" ");
                        }else {
                            label_recycler.add(data3.get(i).getLabel());
                        }
                    }
                    break;
                case CASE_JIAZAI_LOSE:
                    break;
                case TOKEN_LOSE:
                    Intent in=new Intent(getActivity(),LoginActivity.class);
                    startActivity(in);
                    break;

            }
        }
    };


   public void setPopupwindow(){
       // 一个自定义的布局，作为显示的内容
       ColorDrawable dw = new ColorDrawable(0xbffffff);
       View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.popupwindow,null);
       popupWindow = new PopupWindow(contentView,180,230, true);

       //实例化一个ColorDrawable颜色为半透明，已达到变暗的效果

       // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
       // 我觉得这里是API的一个bug
       //聚焦
       popupWindow.setFocusable(true);
       popupWindow.setOutsideTouchable(true);
       popupWindow.setBackgroundDrawable(dw);
       // 设置好参数之后再show
       popupWindow.showAsDropDown(searchbox);
       Popupwindow(contentView);
   }

    private void Popupwindow(View view) {
        case_text=view.findViewById(R.id.case_text);
        article_text=view.findViewById(R.id.article_text);
        stylist_text=view.findViewById(R.id.stylist_text);

        case_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=1;
                find_text.setText("案例");
                popupWindow.dismiss();
            }
        });
        article_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=2;
                find_text.setText("文章");
                popupWindow.dismiss();
            }
        });
        stylist_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=3;
                find_text.setText("设计师");
                popupWindow.dismiss();
            }
        });

    }
    private void setAdapter() {
       // StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        case_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        Case_Recyclerview adapter=new Case_Recyclerview(getActivity(),image_recycler,title_recycler,label_recycler,share_recycler,id,check);
        case_recycler.setAdapter(adapter);
        scrollview.setOnScrollListener(new LazyScrollView.OnScrollListener() {

            @Override
            public void onTop() {

            }

            @Override
            public void onScroll() {

            }

            @Override
            public void onBottom() {
                if (image_recycler.size()>=10) {
                    page++;
                    //在原有的集合之上  接着添加数据
                    getCase();

                }
            }
        });
    }

    private void setImage() {
        banner_rollviewpager.setPlayDelay(5000);
        banner_rollviewpager.setAdapter(new NCarousel(getActivity(),image));
        banner_rollviewpager.setHintView(new ColorPointHintView(getContext(), Color.RED, Color.WHITE));
    }

    public void ImageShow(View view){
//        List<String> l=new ArrayList<>();
//        l.add("http://tz.tuozhe8.com/uploads/images/20180316/43e527cafd55758b2dc6ff9f734ffa75.png");
//        l.add("http://tz.tuozhe8.com/uploads/images/20180316/43e527cafd55758b2dc6ff9f734ffa75.png");
//        l.add("http://tz.tuozhe8.com/uploads/images/20180316/43e527cafd55758b2dc6ff9f734ffa75.png");
//        l.add("http://tz.tuozhe8.com/uploads/images/20180316/43e527cafd55758b2dc6ff9f734ffa75.png");
//        mViewPager = view.findViewById(R.id.pager_container);
//        mVpAdapter = new ViewPagerAdapter(getActivity(), l);
//        mViewPager.setOffscreenPageLimit(3);
//        mViewPager.setAdapter(mVpAdapter);
////      这个值主要负责两边控件与中间控件的距离
//        mViewPager.setPageMargin(-300);
//        mViewPager.setPageTransformer(false, (ViewPager.PageTransformer) new DepthPageTransformer());

        PagerContainer container =view. findViewById(R.id.pager_container);
        ViewPager pager = container.getViewPager();
         myPagerAdapter = new MyPagerAdapter(getActivity(),image_list);
        pager.setAdapter(myPagerAdapter);
        pager.setOffscreenPageLimit(image_list.size()-1);
        pager.setClipChildren(false);
        pager.setCurrentItem(Integer.MAX_VALUE / 2);
        //
        pager.setOffscreenPageLimit(3);

        container.setPageItemClickListener(new PageItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("Normal", "点击：position:"+position);
            }
        });
            new CoverFlow.Builder()
                    .with(pager)
                    .scale(0.3f)
                    .pagerMargin(getResources().getDimensionPixelSize(R.dimen.pager_margin))
                    .spaceSize(0f)
                    .build();
            pager.setPageMargin(30);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("Normal", "滑动："+position % image_list.size() + "");
                stylist_xuhao.setText(name_list.get(position % image_list.size()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        myPagerAdapter.setOnClickItemListener(new OnClickItemListener() {
            @Override
            public void onClickItem(int position) {
                Log.i("Normal", "点击："+position);
            }
        });

    }

    @SuppressLint("LongLogTag")
    public void Banner(){
                if (token.isEmpty())
        {
            return;
        }
        if (!image.isEmpty()&&!contents.isEmpty())
        {
            mHandler.sendEmptyMessage(BANNER);
            return;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringrequest=new StringRequest(UrlUtils.BANNER+"?token="+token+"&version="+ Version.PackageName(getActivity()), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=BANNER;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(BANNER_LOSE);
            }
        });
        requestQueue.add(stringrequest);
    }

    @SuppressLint("LongLogTag")
    public void getListData(){
        if (token.isEmpty())
        {
            return;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringrequest=new StringRequest(UrlUtils.LIST_MODEL+"?token="+token+"&version="+ Version.PackageName(getActivity())+"&type=4", new Response.Listener<String>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject json=new JSONObject(s);
                    String code = json.getString("code");
                    if (code.equals("10001"))
                    {
                        UserManager user=new UserManager(getActivity());
                        user.setData("10002","1","1","1","1","1","1","0","1","1","0","0","0");
                        Toast.makeText(getActivity(), json.getString("message"), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getActivity(), LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Message message=new Message();
                message.obj=s;
                message.what=LIST;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(LIST_LOSE);
            }
        });
        requestQueue.add(stringrequest);
    }


    @SuppressLint("LongLogTag" )
    public void getStylistData(){
        if (token.isEmpty())
        {
            return;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringrequest=new StringRequest(UrlUtils.STYLIST+"?token="+token+"&version="+ Version.PackageName(getActivity()), new Response.Listener<String>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=VIDEO_LIST;
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

    @SuppressLint("LongLogTag")
    public void getCase(){
        if (token.isEmpty())
        {
            return;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=new StringRequest(UrlUtils.CASE_LIST + "?version=" + Version.PackageName(getActivity()) + "&token=" + token + "&page=" + page, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=CASE;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(CASE_LOSE);
            }
        });
        requestQueue.add(stringRequest);
    }

    public void getCaseJiazai(){
        if (token.isEmpty())
        {
            return;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=new StringRequest(UrlUtils.CASE_LIST + "?version=" + Version.PackageName(getActivity()) + "&token=" + token + "&page=" + page, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=CASE_JIAZAI;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(CASE_JIAZAI_LOSE);
            }
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.find_image:

                break;
            case R.id.find_text:
                setPopupwindow();
                break;
//            case R.id.circle_:
//                Intent intent=new Intent(getActivity(), CircleActivity.class);
//                startActivity(intent);
//                break;
        }
    }

    public interface OnClickItemListener{
        void onClickItem(int position);
    }

}
