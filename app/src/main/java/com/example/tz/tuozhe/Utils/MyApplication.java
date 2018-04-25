package com.example.tz.tuozhe.Utils;

import android.content.res.Resources;
import android.os.Bundle;

import com.android.test.runner.MultiDexTestRunner;

/**
 * Created by Tz on 2018/3/20.
 */
public class MyApplication extends MultiDexTestRunner{

    private static MyApplication myApplication;


    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
        myApplication=this;
    }

    public static synchronized MyApplication getInstance(){
        return myApplication;
    }



}

