package com.example.tz.tuozhe.Activity.HomePager;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.example.tz.tuozhe.Utils.LazyScrollView;
import com.example.tz.tuozhe.Utils.MyScrollView;
import com.example.tz.tuozhe.View.Fragment.Owner_Dynamic_Fragment;
import com.example.tz.tuozhe.View.Fragment.Owner_Image_Fragment;
import com.ruffian.library.RVPIndicator;

import java.util.ArrayList;
import java.util.List;

public class OwnerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView head_image,return_;
    private TextView name,follow,fans,money;
    private SharedPreferences data;
    private RVPIndicator my_rvpindicator;
    private ViewPager my_viewpager;
    private MyScrollView scrollview;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private WindowManager windowManager;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> title=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

        initview();
    }

    private void initview() {
        data=this.getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        head_image= (ImageView) findViewById(R.id.head_image);
        name= (TextView) findViewById(R.id.name);
        return_= (ImageView) findViewById(R.id.return_);
        my_rvpindicator= (RVPIndicator) findViewById(R.id.my_rvpindicator);
        my_viewpager= (ViewPager) findViewById(R.id.my_viewpager);
        follow= (TextView) findViewById(R.id.follow);
        fans= (TextView) findViewById(R.id.fans);
        money= (TextView) findViewById(R.id.money);
       // scrollview= (MyScrollView) findViewById(R.id.scrollview);
        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        //scrollview.setOnScrollListener(this);
        head_image.setOnClickListener(this);
        return_.setOnClickListener(this);

        setView();
        setData();
    }

    private void setView() {
        title.add("动态");
        title.add("相册");
        my_rvpindicator.setTitleList(title);
        fragments.add(new Owner_Dynamic_Fragment());
        fragments.add(new Owner_Image_Fragment());
        fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        my_viewpager.setAdapter(fragmentPagerAdapter);
        my_rvpindicator.setViewPager(my_viewpager,0);

    }

    private void setData() {
        GlideUtil.displayRoundImage(this,data.getString("avatar",""),head_image,80);
        name.setText(data.getString("nick_name","拓者设计吧"));
        follow.setText("关注  "+data.getString("follow","0"));
        fans.setText("粉丝  "+data.getString("follower","0"));
        money.setText("金币  "+data.getString("account","0"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.head_image:

                break;
            case R.id.return_:
                finish();
                break;
        }
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus)
//        {
//            height = my_rvpindicator.getHeight();
//            rvp_top = my_rvpindicator.getTop();
//            scroll_top = scrollview.getTop();
//        }
//    }
//
//    @Override
//    public void onBottom() {
//
//    }
//
//    @Override
//    public void onTop() {
//
//    }
//
//    @Override
//    public void onScroll() {
//
//    }
//
//    @Override
//    public void onScroll(int scrollY) {
//        if (scrollY>rvp_top)
//        {
//           if (suspendView==null)
//           {
//               showWindow();
//           }
//        }
//        else if (scrollY<=height+rvp_top)
//        {
//            if (suspendView!=null)
//            {
//                removeWindow();
//            }
//        }
//    }
//
//    // 显示window
//    private void removeWindow() {
//        if (my_rvpindicator != null)
//            windowManager.removeView(my_rvpindicator);
//        isShowWindow = false;
//    }
//
//    // 显示悬浮框
//    private void showWindow() {
//        if (my_rvpindicator == null) {
//            suspendView = LayoutInflater.from(this).inflate(R.id.my_rvpindicator, null);
//        }
//        if (layoutParams == null) {
//            layoutParams = new WindowManager.LayoutParams();
//            layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE; //悬浮窗的类型，一般设为2002，表示在所有应用程序之上，但在状态栏之下
//            layoutParams.format = PixelFormat.RGBA_8888;
//            layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE; //悬浮窗的行为，比如说不可聚焦，非模态对话框等等
//            layoutParams.gravity = Gravity.TOP; //悬浮窗的对齐方式
//            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
//            layoutParams.height = height;
//            layoutParams.x = 0; //悬浮窗X的位置
//            layoutParams.y = scroll_top; //悬浮窗Y的位置
//        }
//        windowManager.addView(suspendView, layoutParams);
//        isShowWindow = true;
//    }



}
