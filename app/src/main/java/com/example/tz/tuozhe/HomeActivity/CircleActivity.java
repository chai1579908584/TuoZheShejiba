package com.example.tz.tuozhe.HomeActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tz.tuozhe.R;

public class CircleActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView return_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        inirview();
    }

    private void inirview() {
        return_= (ImageView) findViewById(R.id.return_);

        return_.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.return_:
                finish();
                break;
        }
    }
}
