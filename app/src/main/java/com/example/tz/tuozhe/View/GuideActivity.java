package com.example.tz.tuozhe.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.tz.tuozhe.Adapter.GuideAdapter;
import com.example.tz.tuozhe.Common.BaseActivity;
import com.example.tz.tuozhe.Presenter.GuidePresenter;
import com.example.tz.tuozhe.Presenter.GuidePresenterImpl;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.OtherUtils;
import com.example.tz.tuozhe.Utils.SettingUtils;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.View.Fragment.GuideFragment;

import java.util.ArrayList;


/*
* 引导页面
* 1.获取 SettingUtils 工具类里的变量 GUIDE_PIC
*   1.1 为true时，执行 P 层 GuidePresenterImpl 类，在接口回调 afterPics()方法里添加碎片，并传递图片的网址和一个 int 值
*   1.2 为false时，执行 initBgPics()方法，传递 OtherUtils 工具类里的图片数组 GUIDE_PIC 到碎片，在碎片中设置图片
* 2.拿到图片数据后，调用 inllPoints()方法，参数int 类型的图片个数，动态添加相应个数的指示点，用来告知用户当前是第几个引导页
* */
public class GuideActivity extends BaseActivity implements GuideView {

    ViewPager vpGuide;
    LinearLayout llPoints;

    private GuidePresenter mGuidePresenter;
    private ArrayList<Fragment> fragmentArrayList;
    private GuideAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        vpGuide= (ViewPager) findViewById(R.id.vpGuide);
        llPoints= (LinearLayout) findViewById(R.id.llPoints);
        if (SettingUtils.GUIDE_PIC) {
            mGuidePresenter = new GuidePresenterImpl(this);
            mGuidePresenter.onLoadPics(UrlUtils.GUIDE_URL);
        } else {
            initBgPics();//给 ViewPager 设置图片，引导页图片为本地图片时调用该方法
        }
    }

    //给 ViewPager 设置图片
    private void initBgPics() {
        fragmentArrayList = new ArrayList<>();
        inllPoints(OtherUtils.GUIDE_PICS.length);
        for (int i = 0; i < OtherUtils.GUIDE_PICS.length; i++) {
            fragmentArrayList.add(new GuideFragment(null, i));
        }
        adapter = new GuideAdapter(getSupportFragmentManager(), fragmentArrayList);
        vpGuide.setAdapter(adapter);
    }

    @Override
    public void afterPics(boolean isSuccess, String error, final ArrayList<String> pics) {
        if (SettingUtils.GUIDE_PIC) {
            inllPoints(pics.size());
            if (isSuccess) {
                fragmentArrayList = new ArrayList<>();
                for (int i = 0; i < pics.size(); i++) {
                    fragmentArrayList.add(new GuideFragment(pics, i));
                }
                adapter = new GuideAdapter(getSupportFragmentManager(), fragmentArrayList);
                vpGuide.setAdapter(adapter);
            } else {
                showToast("错误: " + error);
            }
        }
    }

    //设置相应个数的小圆点
    private void inllPoints(final int number) {
        if (!SettingUtils.GUIDE_POINT) {
            return;
        }
        vpGuide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                inllPoints(number);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        llPoints.removeAllViews();
        ImageView imageView;
        LinearLayout.LayoutParams layoutParams;
        for (int j = 0; j < number; j++) {
            imageView = new ImageView(this);
            imageView.setId(j);
            if (j == vpGuide.getCurrentItem()) {
                imageView.setBackgroundResource(OtherUtils.GUIDE_POINTS[0]);//选中
            } else {
                imageView.setBackgroundResource(OtherUtils.GUIDE_POINTS[1]);//未选中
            }
            llPoints.addView(imageView);
            layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.height = 20;
            layoutParams.width = 20;
            layoutParams.leftMargin = 4;
            layoutParams.rightMargin = 4;
        }

    }

    @Override
    public Activity getContent() {
        return GuideActivity.this;
    }
}
