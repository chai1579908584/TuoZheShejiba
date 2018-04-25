package com.example.tz.tuozhe.Common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.tz.tuozhe.Utils.ToastUtils;
import com.tencent.bugly.crashreport.CrashReport;


/**
 * Activity 基类
 * 提供了 showToast 方法，方便 Activity 使用吐司打印
 * 提供了 startActivity 方法，方便 Activity 进行跳转 第一个参数：要跳转到的 Activity 类名 第二个参数：当前 Activity 是否销毁（true：销毁  false：不销毁）
 * 提供了 showDialog 和 hideDialog 方法，主要是为了简单的展示一下加载状态。
 */

public class BaseActivity extends AppCompatActivity {
    protected Handler mHandler = new Handler();

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CrashReport.initCrashReport(getApplicationContext(), "b4f8ec657c", true);
        mProgressDialog = new ProgressDialog(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProgressDialog.dismiss();
    }

    public void showDialog(String msg,boolean isCancelable ){
        mProgressDialog.setCancelable(isCancelable);
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    public void hideDialog(){
        if (mProgressDialog.isShowing()){
            mProgressDialog.hide();
        }
    }

    public void startActivity(Class clazz, boolean isFinish) {
        startActivity(new Intent(this, clazz));
        if (isFinish) {
            finish();
        }
    }

    public void showToast(String msg) {
        ToastUtils.showToast(this, msg);
    }

}
