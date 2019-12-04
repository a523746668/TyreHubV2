package com.example.tyrehubv2;

import android.app.Application;
import android.media.session.MediaSession;
import android.text.TextUtils;

import com.example.tyrehubv2.activiry.BaseActivity;
import com.example.tyrehubv2.model.UserDetail;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpHeaders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyApplication extends Application {
    public String  mToken=null;
    public static String DEVICE_MODEL="michelin.tyrescan.ts003";
    public static String APP_VERSION="1.1.2";
    public UserDetail  userData;  //用户信息
    public List<BaseActivity> activities=new ArrayList<>();

    public String getmToken() {
        return mToken;
    }

    public void setmToken(String mToken) {
        this.mToken = mToken;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initNetWork();

    }

    private void initNetWork() {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                if(!TextUtils.isEmpty(mToken)){

                   return  chain.proceed(request.newBuilder().addHeader("Authorization",mToken).build());
                }
                return chain.proceed(request);
            }
        }).build();
        HttpHeaders headers = new HttpHeaders();
        headers.put("Device-Model",DEVICE_MODEL);
        headers.put("App-Version",APP_VERSION);
        OkGo.getInstance().init(this).setOkHttpClient(client).addCommonHeaders(headers);
    }


}
