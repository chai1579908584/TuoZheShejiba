package com.example.tz.tuozhe.Utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * 吐司的工具类
 * 工具类里直接封装了一个 Handler
 * 通过方法判断当前线程是否为主线程
 * 主线程直接展示吐司，子线程先切换为主线程再展示吐司
 * 对外提供 showToast() 方法
 */
public class ToastUtils {

    private static Toast sToast;
    private static Handler handler = new Handler(Looper.getMainLooper());

    public static void showToast(final Context context, final String msg) {

        if (sToast == null) {
          if (Looper.getMainLooper()==Looper.myLooper()){
              initToast(context, msg);
          }else {
              handler.post(new Runnable() {
                  @Override
                  public void run() {
                      initToast(context, msg);
                  }
              });
          }
        }
        //判断当前代码是否是主线程
        if (Looper.myLooper() == Looper.getMainLooper()) {
            sToast.setText(msg);
            sToast.show();
        } else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    sToast.setText(msg);
                    sToast.show();
                }
            });
        }
    }

    private static void initToast(Context context, String msg) {
        sToast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
        sToast.setText(msg);
    }
}
