package com.example.tz.tuozhe.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tz.tuozhe.R;

public class RegisterActivity_Select extends AppCompatActivity implements View.OnClickListener {

    private TextView login;
    private RelativeLayout owner,stylist;
    private ImageView return_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initview();
    }

    private void initview() {
        login= (TextView) findViewById(R.id.login);
        owner= (RelativeLayout) findViewById(R.id.owner);
        stylist= (RelativeLayout) findViewById(R.id.stylist);
        return_= (ImageView) findViewById(R.id.return_);

        login.setOnClickListener(this);
        owner.setOnClickListener(this);
        stylist.setOnClickListener(this);
        return_.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.login:
                finish();
                break;
            case R.id.owner:
                Intent intent_owner=new Intent(RegisterActivity_Select.this,RegisterActivity.class);
                intent_owner.putExtra("owner_stylist","1");
                startActivity(intent_owner);
                finish();
                break;
            case R.id.stylist:
                Intent intent_stylist=new Intent(RegisterActivity_Select.this,RegisterActivity.class);
                intent_stylist.putExtra("owner_stylist","2");
                startActivity(intent_stylist);
                finish();
                break;
            case R.id.return_:
                finish();
                break;
        }
    }

}
