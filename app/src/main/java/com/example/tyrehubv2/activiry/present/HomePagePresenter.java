package com.example.tyrehubv2.activiry.present;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.example.tyrehubv2.activiry.View.HomePageView;
import com.example.tyrehubv2.callback.JsonCallback;
import com.example.tyrehubv2.model.ChanceModel;
import com.example.tyrehubv2.util.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

public class HomePagePresenter {
    private HomePageView mView;
    private Context mContext;

    public HomePagePresenter(HomePageView mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


    //获取机会未读数量
    public void getUnreadCount() {

        OkGo.<ChanceModel>get(Urls.Chance_List_Url)
                .params("statu", "chance")
                .execute(new JsonCallback<ChanceModel>(false, mContext) {
                    @Override
                    public void onSuccess(Response<ChanceModel> response) {
                        ChanceModel model = response.body();
                        if (model != null && model.code == 0) {
                            mView.refreshCount(model.data.reports == null ? 0 : model.data.reports.size());
                        }
                    }
                });


    }


    //判断当前App是否需要更新
    public void getAppVersion() {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = mContext.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(mContext.getPackageName(), 0);
            localVersion = packageInfo.versionCode;
            Log.d("TAG", "当前版本号：" + localVersion);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


    }
}