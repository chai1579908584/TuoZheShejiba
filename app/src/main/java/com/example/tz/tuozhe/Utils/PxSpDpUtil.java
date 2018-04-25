package com.example.tz.tuozhe.Utils;

import android.content.Context;


/**
 * Created by NEU on 2017/9/19.
 */

public class PxSpDpUtil {

    /**
     * px转dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * dip转px函数。
     *
     * @param context
     *            程序上下文
     * @param dpValue
     *            dip值
     * @return px值
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
//    public static int dip2px(float dpValue) {
//        final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;
//        return (int) (dpValue * scale + 0.5f);
//    }

}
