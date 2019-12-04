package com.example.tyrehubv2.activiry.present;

import android.content.Context;

import com.example.tyrehubv2.activiry.View.ChanceView;
import com.example.tyrehubv2.callback.JsonCallback;
import com.example.tyrehubv2.model.ChanceModel;
import com.example.tyrehubv2.util.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;


public class ChancePresenter {

    private ChanceView mView;
    private Context mContext;

    public ChancePresenter(ChanceView mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }

    public void getChanceData(String status){
       OkGo.<ChanceModel>get(Urls.Chance_List_Url)
               .params("statu", status)
               .execute(new JsonCallback<ChanceModel>( mContext) {
                   @Override
                   public void onSuccess(Response<ChanceModel> response) {
                       ChanceModel model = response.body();
                       if (model != null && model.code == 0) {
                              if(model.data.reports!=null&&model.data.reports.size()>0){
                                  mView.refreshRecyclerview(model.data.reports);
                              }else {
                                  mView.refreshNoData();
                              }
                       }
                   }
               });

   }

}
