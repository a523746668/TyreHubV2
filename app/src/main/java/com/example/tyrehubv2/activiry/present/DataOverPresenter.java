package com.example.tyrehubv2.activiry.present;

import android.content.Context;

import com.example.tyrehubv2.activiry.View.DataOverView;
import com.example.tyrehubv2.callback.JsonCallback;
import com.example.tyrehubv2.dialog.ChanceDealDialog;
import com.example.tyrehubv2.model.AllDataModel;
import com.example.tyrehubv2.model.Item;
import com.example.tyrehubv2.util.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;

public class DataOverPresenter {

    private DataOverView mView;
    private Context mContext;

    public DataOverPresenter(DataOverView mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


    public void getTotalDataForTime(Item time){
        OkGo.<AllDataModel>get(Urls.DataOver_Total_data)
        .params("device_time", time.value)
        .execute(new JsonCallback<AllDataModel>(mContext) {
            @Override
            public void onSuccess(Response<AllDataModel> response) {
                    AllDataModel model=response.body();
                    if(model.code==0){

                    }
            }
        });
    }


}
