package com.example.tz.tuozhe.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Bean.ModificationBean;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.UserManager;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import retrofit2.http.Url;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rl_box,region;
    private ImageView return_,head_image;
    private TextView change,city_text;
    private EditText name_edit,signature_edit;
    private RadioButton sex_nan,sex_nv;
    private RadioGroup radioGroup;
    private Button sure;
    private static final int IMAGE_REQUEST_CODE=1;
    private static final int RESULT_REQUEST_CODE=2;
    private static final int MODIFICATION=3;
    private static final int MODIFICATION_LOSE=4;
    private static final int IMAGEUP=5;
    private static final int IMAGE=7;
    private SharedPreferences data;
    private ByteArrayOutputStream outStream;
    private int SEX;
    private String city_;
    private InputMethodManager imm;
    private static final String IMAGE_NAME = "faceImage.jpg";
    private String imagePath = Environment.getExternalStorageDirectory() + File.separator + IMAGE_NAME;
    private Gson g=new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compile);

        initview();
    }

    private void initview() {
        imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        SEX=1;
        data =getApplicationContext().getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        city_=data.getString("address","");
        return_= (ImageView) findViewById(R.id.return_);
        change= (TextView) findViewById(R.id.change);
        name_edit= (EditText) findViewById(R.id.name_edit);
        rl_box= (RelativeLayout) findViewById(R.id.rl_box);
        head_image= (ImageView) findViewById(R.id.head_image);
        sex_nan= (RadioButton) findViewById(R.id.sex_nan);
        sex_nv= (RadioButton) findViewById(R.id.sex_nv);
        city_text= (TextView) findViewById(R.id.city_text);
        region= (RelativeLayout) findViewById(R.id.region);
        signature_edit= (EditText) findViewById(R.id.signature_edit);
        sure= (Button) findViewById(R.id.sure);
        radioGroup= (RadioGroup) findViewById(R.id.sex_selector);


        return_.setOnClickListener(this);
        change.setOnClickListener(this);
        name_edit.setOnClickListener(this);
        rl_box.setOnClickListener(this);
        sex_nan.setOnClickListener(this);
        sex_nv.setOnClickListener(this);
        region.setOnClickListener(this);
        signature_edit.setOnClickListener(this);
        sure.setOnClickListener(this);

        setData();
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case MODIFICATION:
                    ModificationBean modificationBean = g.fromJson(msg.obj.toString(), ModificationBean.class);
                    ModificationBean.DataBean modification = modificationBean.getData();
                    UserManager user=new UserManager(getApplicationContext());
                    user.setData(data.getString("token",""),modification.getLogin_name(), modification.getNick_name(),modification.getSex(),modification.getUid(),data.getString("user_type",""), modification.getAvatar(),"1",modification.getAddress(),modification.getIntro(),data.getString("account","0"),data.getString("follow","0"),data.getString("follower","0"));
                    Toast.makeText(EditProfileActivity.this,modificationBean.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case MODIFICATION_LOSE:
                    Toast.makeText(EditProfileActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                    break;
                case IMAGEUP:
                    try {
                        JSONObject json=new JSONObject(msg.obj.toString());
                        String message = json.getString("message");
                        JSONObject url = json.getJSONObject("data");
                        String image_url = url.getString("url");
                        UserManager image=new UserManager(getApplicationContext());
                        image.setData(data.getString("token",""),data.getString("mobile_name",""), data.getString("nick_name",""),data.getString("sex",""),data.getString("uid",""),data.getString("user_type",""), image_url,"1",data.getString("address",""),data.getString("intor",""),data.getString("account","0"),data.getString("follow","0"),data.getString("follower","0"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }
    };

    private void setData() {
        GlideUtil.displayRoundImage(getApplicationContext(),data.getString("avatar",""),head_image,55);
        name_edit.setText(data.getString("nick_name",""));
        String sex = data.getString("sex", "1");
        if (sex.equals("1"))
        {
            radioGroup.check(sex_nan.getId());
        }else if (sex.equals("2"))
        {
            radioGroup.check(sex_nv.getId());
        }
        city_text.setText(city_);
        signature_edit.setText(data.getString("intro",""));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.return_:
                finish();
                break;
            case R.id.change:
                verifyStoragePermissions();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
                //intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, IMAGE_REQUEST_CODE);
                break;
            case R.id.name_edit:
                name_edit.setFocusable(true);
                name_edit.setFocusableInTouchMode(true);
                name_edit.requestFocus();
                name_edit.findFocus();
                break;
            case R.id.rl_box:
                name_edit.setFocusable(false);
                signature_edit.setFocusable(false);
                imm.hideSoftInputFromWindow(name_edit.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(signature_edit.getWindowToken(), 0);
                return;
            case R.id.sex_nan:
                SEX=1;
                break;
            case R.id.sex_nv:
                SEX=2;
                break;
            case R.id.region:
                if (imm.isActive()) {
                    imm.hideSoftInputFromWindow(name_edit.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    imm.hideSoftInputFromWindow(signature_edit.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    selectAddress();//调用CityPicker选取区域
                }
                break;
            case R.id.signature_edit:
                signature_edit.setFocusable(true);
                signature_edit.setFocusableInTouchMode(true);
                signature_edit.requestFocus();
                signature_edit.findFocus();
                break;
            case R.id.sure:
                modification();
                break;

        }
    }

    private void modification() {
        if (name_edit.getText().length()<=0)
        {
            Toast.makeText(EditProfileActivity.this, "昵称不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url=UrlUtils.MODIFICATION+"?version="+Version.PackageName(getApplicationContext())+"&token="+data.getString("token","")+"&nick_name="+name_edit.getText()+"&sex="+SEX+"&intro="+signature_edit.getText()+"&address="+city_;
        StringRequest stringQuest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=MODIFICATION;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
              mHandler.sendEmptyMessage(MODIFICATION_LOSE);
            }
        });
        requestQueue.add(stringQuest);
    }

    private void selectAddress() {
        CityPicker cityPicker = new CityPicker.Builder(EditProfileActivity.this)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#FFFFFF")
                .confirTextColor("#696969")
                .cancelTextColor("#696969")
                .province("北京市")
                .city("北京市")
                .district("昌平区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                city_text.setText(province.trim() +  city.trim() + district.trim());
                city_=province.trim() +  city.trim() + district.trim();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        //在相册里面选择好相片之后调回到现在的这个activity中
        switch (requestCode) {
            case IMAGE_REQUEST_CODE:
                if (data!=null)
                {
                    startPhotoZoom(data.getData());
                }
                break;
            case RESULT_REQUEST_CODE:
                uploading();
                break;

        }
    }

    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 400);
        intent.putExtra("outputY", 400);
        intent.putExtra("return-data", false);
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(imagePath)));
        startActivityForResult(intent, RESULT_REQUEST_CODE);
    }

    private void uploading() {

        Map<String, String> params = new HashMap<>();
        params.put("token", data.getString("token",""));
        params.put("version", Version.PackageName(getApplicationContext()));
        OkHttpUtils.post()
                .addFile("avatar","agguigu-afu.jpe",new File(imagePath))
                .url(UrlUtils.UPLOADING)
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        mHandler.sendEmptyMessage(MODIFICATION_LOSE);
                    }
                    @Override
                    public void onResponse(Call call, String s) {
                        Message message=new Message();
                        message.obj=s;
                        message.what=IMAGEUP;
                        mHandler.sendMessage(message);
                    }
                });
    }
    //动态获取内存存储权限
    public void verifyStoragePermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //验证是否许可权限
            for (String str : permissions) {
                if (EditProfileActivity.this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }
    }
}

