package com.example.tz.tuozhe.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RadioGroup;


import com.example.tz.tuozhe.Adapter.MyFragmentPagerAdapter;
import com.example.tz.tuozhe.Bean.UserInfoModel;
import com.example.tz.tuozhe.Common.BaseActivity;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.NoScrollViewPager;
import com.example.tz.tuozhe.Utils.SharedUtils;
import com.example.tz.tuozhe.View.Fragment.HomePageFragment;
import com.example.tz.tuozhe.View.Fragment.DynamicFragment;
import com.example.tz.tuozhe.View.Fragment.StylistFragment;
import com.example.tz.tuozhe.View.Fragment.CaseFragment;
import com.example.tz.tuozhe.View.Fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

/*
* 主页面
* 默认填充了4个 Fragment + RadioButton
* 如需添加或减少
* 1.手动修改一下 activity_home.xml 布局文件中的 RadioButton 数量
* 2.初始化数据 initData() 方法里，修改 alFragment 集合里的数据
* 3.初始化监听事件 initListener() 方法里，修改两个监听事件，主要是 switch 里的 case 语句的添加和减少
* */

public class HomeActivity extends BaseActivity {

    private long exitTime = 0;//监听返回键的点击间隔时间
    private NoScrollViewPager viewPager;
    private RadioGroup radioGroup;
    private  UserInfoModel data=new UserInfoModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_home);
        //openAppNumbers();//方法  APP 的打开次数
        initView();//实例化控件
        initListener();//初始化监听事件
        initData();//初始化数据

    }


    //实例化控件
    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_home_button);//RadioGroup
        viewPager = (NoScrollViewPager) findViewById(R.id.home_viewpager);//ViewPager
    }

    //初始化监听事件
    private void initListener() {
        //RadioGroup选中状态改变监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radiobutton_home:
                        //setCurrentItem第二个参数控制页面切换动画   true:打开  false:关闭
                        viewPager.setCurrentItem(0, true);
                        break;
                    case R.id.radiobutton_pic:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.radiobutton_stylist_option:
                        viewPager.setCurrentItem(2, true);
                        break;
                    case R.id.radiobutton_voide:
                        viewPager.setCurrentItem(3, true);
                        break;
                    case R.id.radiobutton_my:
                        viewPager.setCurrentItem(4, true);
                        break;
                }
            }
        });

        //ViewPager页面切换监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.radiobutton_home);
                        break;
                    case 1:
                        radioGroup.check(R.id.radiobutton_pic);
                        break;
                    case 2:
                        radioGroup.check(R.id.radiobutton_stylist_option);
                        break;
                    case 3:
                        radioGroup.check(R.id.radiobutton_voide);
                        break;
                    case 4:
                        radioGroup.check(R.id.radiobutton_my);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //初始化数据
    private void initData() {
        List<Fragment> alFragment = new ArrayList<>();
        //添加 Fragment 碎片
        alFragment.add(new HomePageFragment());
        alFragment.add(new DynamicFragment());
        alFragment.add(new StylistFragment());
        alFragment.add(new CaseFragment());
        alFragment.add(new MineFragment());
        //ViewPager设置适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), alFragment));
        viewPager.setOffscreenPageLimit(4);
        //ViewPager显示第一个Fragment
        viewPager.setCurrentItem(0);
    }

    //方法  APP 的打开次数
    private void openAppNumbers() {
        int appNumbaer = SharedUtils.getAppNumbaer(HomeActivity.this);
        int number = ++appNumbaer;
        SharedUtils.setAppNumbaer(HomeActivity.this, number);
        showToast("APP 打开次数: " + number);
    }

    //按两次返回键退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                showToast("再按一次退出APP");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
