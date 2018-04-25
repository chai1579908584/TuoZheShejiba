package com.example.tz.tuozhe.Activity.Case;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.tz.tuozhe.Adapter.Case_Recyclerview;
import com.example.tz.tuozhe.Adapter.CommentList_Recycler;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.example.tz.tuozhe.Utils.LazyScrollView;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Case_ParticularsOwner extends AppCompatActivity implements View.OnClickListener {

    private ImageView return_,transmit,return_owner,head_image,comment_image;
    private RadioButton like_image;
    private WebView webView;
    private EditText comment_edit;
    private TextView like_text,comment_text,stylist_name,price_text;
    private Button comment_button;
    private LazyScrollView scrollView;
    private String islike;
    private SharedPreferences data;
    private String token;
    private static final int LIKE_COMMENT=1;
    private static final int DETAILS=2;
    private static final int COMMENT=3;
    private static final int COLLECT=4;
    private static final int COMMENT_LIST=5;
    private static final int MISTAKE=0;
    private int like_count;
    private int comment_count;
    private RelativeLayout title_box;
    private RelativeLayout rl_box,out_,rl_maxbox;
    private InputMethodManager imm;
    private String id;
    private String type,iscollect;
    private RadioButton collect;
    private RecyclerView comment_recycler;
    private List<String> image=new ArrayList<>();
    private List<String> name=new ArrayList<>();
    private List<String> time=new ArrayList<>();
    private List<String> content=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case__particulars);

        initview();
        myWabView();
    }

    private void initview() {
        imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        data=getApplicationContext().getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        token = data.getString("token", "");
        webView= (WebView) findViewById(R.id.my_webview);
        return_= (ImageView) findViewById(R.id.return_);
        return_owner= (ImageView) findViewById(R.id.return_owner);
        comment_edit= (EditText) findViewById(R.id.comment_edit);
        transmit= (ImageView) findViewById(R.id.transmit);
        like_image= (RadioButton) findViewById(R.id.like_image);
        like_text= (TextView) findViewById(R.id.like_text);
        comment_text= (TextView) findViewById(R.id.comment_text);
        title_box= (RelativeLayout) findViewById(R.id.title_box);
        rl_box= (RelativeLayout) findViewById(R.id.rl_box);
        head_image= (ImageView) findViewById(R.id.head_image);
        stylist_name= (TextView) findViewById(R.id.stylist_name);
        price_text= (TextView) findViewById(R.id.price_text);
        comment_button= (Button) findViewById(R.id.comment_button);
        comment_image= (ImageView) findViewById(R.id.comment_image);
        out_= (RelativeLayout) findViewById(R.id.out_);
        rl_maxbox= (RelativeLayout) findViewById(R.id.rl_maxbox);
        collect= (RadioButton) findViewById(R.id.collect);
        comment_recycler= (RecyclerView) findViewById(R.id.comment_recycler);
        scrollView= (LazyScrollView) findViewById(R.id.scrollView);

        comment_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    focus();
                }else {
                    cencelfocus();
                }
            }
        });

        rl_maxbox.setOnClickListener(this);
        return_.setOnClickListener(this);
        comment_edit.setOnClickListener(this);
        transmit.setOnClickListener(this);
        like_image.setOnClickListener(this);
        return_owner.setOnClickListener(this);
        comment_button.setOnClickListener(this);
        comment_image.setOnClickListener(this);
        collect.setOnClickListener(this);
        comment_recycler.setOnClickListener(this);

        if (getIntent().getStringExtra("check").equals("1"))
        {
            title_box.setVisibility(View.GONE);
            rl_box.setVisibility(View.GONE);
        }else if (getIntent().getStringExtra("check").equals("2"))
        {
            return_owner.setVisibility(View.GONE);
        }else {
            return;
        }


        getData();
    }
    Handler mHandler=new Handler(){
        @SuppressLint("LongLogTag")
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
           switch (msg.what)
           {
               case DETAILS:
                   try {
                       JSONObject json=new JSONObject(msg.obj.toString());
                       JSONObject data = json.getJSONObject("data");
                        islike = data.getString("is_like");
                        like_count = Integer.parseInt(data.getString("like_count"));
                        comment_count= Integer.parseInt(data.getString("comment_count"));
                       id = data.getString("id");
                       type = data.getString("type");
                       iscollect=data.getString("collect");
                       JSONObject designer = data.getJSONObject("designer");
                       GlideUtil.displayRoundImage(getApplicationContext(),designer.getString("avatar"),head_image,50);
                       stylist_name.setText("设计师："+designer.getString("nick_name"));
                       if (designer.getString("charge").equals("收费面议"))
                       {
                           price_text.setText("设计费用："+designer.getString("charge"));
                       }else {
                           price_text.setText("设计费用：" + designer.getString("charge") + "元/平米");
                       }
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
                   setData();
                   getCommentList();
                   break;
               case COMMENT:
                   try {
                       JSONObject json=new JSONObject(msg.obj.toString());
                       String message = json.getString("message");
                       Toast.makeText(Case_ParticularsOwner.this,message, Toast.LENGTH_SHORT).show();
                       comment_count++;
                       comment_text.setText(comment_count+"");
                       comment_edit.setText("");
                       getCommentList();
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
                   break;
               case COLLECT:
                   try {
                       JSONObject json=new JSONObject(msg.obj.toString());
                       String message = json.getString("message");
                       Toast.makeText(Case_ParticularsOwner.this,message, Toast.LENGTH_SHORT).show();
                       if (message.equals("收藏成功"))
                       {
                           iscollect="1";
                           collect.setChecked(true);
                       }else if(message.equals("取消成功")){
                           iscollect="0";
                           collect.setChecked(false);
                       }else {
                           return;
                       }
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
                   break;
               case LIKE_COMMENT:
                   try {
                       JSONObject json=new JSONObject(msg.obj.toString());
                       String message = json.getString("message");
                       Toast.makeText(Case_ParticularsOwner.this,message, Toast.LENGTH_SHORT).show();
                       if (islike.equals("0"))
                       {
                           like_count++;
                           like_text.setText(like_count+"");
                           islike="1";
                       }else if(islike.equals("1"))
                       {
                           like_count--;
                           like_text.setText(like_count+"");
                           islike="0";
                           like_image.setChecked(false);
                       }
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
                   break;
               case MISTAKE:
                   Toast.makeText(Case_ParticularsOwner.this, "网络错误", Toast.LENGTH_SHORT).show();
                   break;
               case COMMENT_LIST:
                   try {
                       JSONObject json=new JSONObject(msg.obj.toString());
                       JSONArray data = json.getJSONArray("data");
                       time.clear();
                       name.clear();
                       time.clear();
                       content.clear();
                       for (int i = 0; i < data.length(); i++) {
                           JSONObject jsonObject = data.getJSONObject(i);
                           time.add(jsonObject.getString("created_at"));
                           content.add(jsonObject.getString("content"));
                           JSONObject created_user = jsonObject.getJSONObject("created_user");

                           if (created_user==null)
                           {
                               return;
                           }else {
                               image.add(created_user.getString("avatar"));
                               name.add(created_user.getString("nick_name"));
                               setCommentAdapter();
                           }
                       }
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }


                   break;
           }
        }
    };

    private void setCommentAdapter() {
        comment_recycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        CommentList_Recycler adapter=new CommentList_Recycler(getApplicationContext(),image,name,time,content);
        comment_recycler.setAdapter(adapter);

    }

    private void getCommentList() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(UrlUtils.COMMENT_LIST + "?version=" + Version.PackageName(getApplicationContext()) + "&token=" + token + "&posts_id=" + id + "&type=" + type, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=COMMENT_LIST;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(UrlUtils.DETAILS + "?token=" + token + "&version=" + Version.PackageName(getApplicationContext()) + "&type=1" + "&id=" + getIntent().getStringExtra("id"), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=DETAILS;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }

    private void setData() {
        if (islike.equals("1"))
        {
            like_image.setChecked(true);
        }
        if (iscollect.equals("1"))
        {
            collect.setChecked(true);
        }
        like_text.setText(like_count+"");
        comment_text.setText(comment_count+"");
    }

    private void myWabView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getIntent().getStringExtra("html"));
        webView.setScrollContainer(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.return_:
                finish();
                break;
            case R.id.return_owner:
                finish();
                break;
            case R.id.transmit:

                break;
            case R.id.like_image:
                if (islike.equals("0"))
                {
                    like();
                }else if (islike.equals("1"))
                {
                    cancel();
                }
                break;
            case R.id.comment_image:
                comment_edit.setFocusable(true);
                comment_edit.setFocusableInTouchMode(true);
                comment_edit.requestFocus();
                break;
            case R.id.comment_button:
                comment();
            break;
            case R.id.rl_maxbox:
                comment_edit.setFocusable(false);
                imm.hideSoftInputFromWindow(comment_edit.getWindowToken(), 0);
                break;
            case R.id.collect:
                if (iscollect.equals("0"))
                {
                    collectcase();
                }else if (iscollect.equals("1"))
                {
                    cencel_collectcase();
                }else {
                    return;
                }
                break;

            case R.id.comment_recycler:
                comment_edit.setFocusable(false);
                imm.hideSoftInputFromWindow(comment_edit.getWindowToken(), 0);
                break;
        }
    }

    private void cencel_collectcase() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(UrlUtils.CENCEL_COLLECT + "?version=" + Version.PackageName(getApplicationContext()) + "&token=" + token + "&id=" + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=COLLECT;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }

    private void collectcase() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(UrlUtils.COLLECT + "?version=" + Version.PackageName(getApplicationContext()) + "&token=" + token + "&id=" + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=COLLECT;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }

    private void comment() {
        if (comment_edit.getText().toString().equals(""))
        {
            Toast.makeText(Case_ParticularsOwner.this,"请输入评论内容", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(UrlUtils.COMMENT + "?version=" + Version.PackageName(getApplicationContext()) + "&token=" + token + "&posts_id=" + id + "&content=" + comment_edit.getText() + "&type=" + type, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
               Message message=new Message();
                message.obj=s;
                message.what=COMMENT;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                 mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }

    private void focus() {
        out_.setVisibility(View.GONE);
        comment_button.setVisibility(View.VISIBLE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
    private void cencelfocus() {
        out_.setVisibility(View.VISIBLE);
        comment_button.setVisibility(View.GONE);
        imm.hideSoftInputFromWindow(comment_edit.getWindowToken(), 0);
    }

    private void like() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(UrlUtils.LIKE + "?token=" + token + "&version=" + Version.PackageName(getApplicationContext()) + "&type=1" + "&posts_id=" + getIntent().getStringExtra("id"), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=LIKE_COMMENT;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }
    private void cancel() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(UrlUtils.CENCEL_LIKE + "?token=" + token + "&version=" + Version.PackageName(getApplicationContext()) + "&type=1" + "&posts_id=" + getIntent().getStringExtra("id"), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=LIKE_COMMENT;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(MISTAKE);
            }
        });
        requestQueue.add(stringRequest);
    }


}
