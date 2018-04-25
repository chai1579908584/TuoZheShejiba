package com.example.tz.tuozhe.Common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tz.tuozhe.Utils.ToastUtils;


/**
 * Fragment 基类
 * 提供了 showToast 方法，方便 Fragment 使用吐司打印
 * 提供了 startActivity 方法，方便 Fragment 进行跳转 第一个参数：要跳转到的 Activity 类名 第二个参数：当前 Activity 是否销毁（true：销毁  false：不销毁）
 * 提供了 showDialog 和 hideDialog 方法，主要是为了简单的展示一下加载状态。
 */
public class BaseFragment extends Fragment {

    private ProgressDialog mProgressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialog = new ProgressDialog(getActivity());
    }

    public void showToast(String msg) {
        ToastUtils.showToast(getActivity(), msg);
    }

    public void startActivity(Class clazz, boolean isFinish) {
        startActivity(new Intent(getActivity(), clazz));
        if (isFinish) {
            getActivity().finish();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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

}
