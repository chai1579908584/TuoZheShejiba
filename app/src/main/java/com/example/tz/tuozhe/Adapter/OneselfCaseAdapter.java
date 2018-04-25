package com.example.tz.tuozhe.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tz on 2018/4/16.
 */
public class OneselfCaseAdapter extends RecyclerView.Adapter<OneselfCaseAdapter.My> {


    @Override
    public My onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(My holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class My extends RecyclerView.ViewHolder {
        public My(View itemView) {
            super(itemView);
        }
    }
}

