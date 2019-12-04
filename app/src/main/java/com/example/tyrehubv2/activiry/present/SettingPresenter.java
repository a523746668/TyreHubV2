package com.example.tyrehubv2.activiry.present;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.example.tyrehubv2.MyApplication;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.binder.item.SettingItem1;
import com.example.tyrehubv2.View.binder.item.SettingItem2;
import com.example.tyrehubv2.View.binder.item.SettingItem3;
import com.example.tyrehubv2.activiry.BaseActivity;
import com.example.tyrehubv2.activiry.View.SettingView;
import com.example.tyrehubv2.callback.JsonCallback;
import com.example.tyrehubv2.model.SettingModel;
import com.example.tyrehubv2.model.UserDetail;
import com.example.tyrehubv2.util.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class SettingPresenter {
    private BaseActivity mContext;
    private SettingView mView;

    public SettingPresenter(BaseActivity mContext, SettingView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

   public void getSettingData(){
       OkGo.<SettingModel>get(Urls.Setting_Detail_Url)
               .execute(new JsonCallback<SettingModel>(false,mContext) {
                   @Override
                   public void onSuccess(Response<SettingModel> response) {
                          // mView.refreshView(dealData());
                   }
               });
   }

   public void dealData(){
      UserDetail.DataBean.UserBean bean= mContext.getMyApplication().userData.getData().getUser();
       List<Object> list=new ArrayList<>();
       SettingItem2  item1=new SettingItem2();
       item1.name=mContext.getStr(R.string.TxTBasicMessage);
       list.add(item1);
       SettingItem1 item2=new SettingItem1();
       item2.name=mContext.getStr(R.string.TxTUserId);
       item2.value=bean.getNumber();
       list.add(item2);
       SettingItem1 item3=new SettingItem1();
       item3.name=mContext.getStr(R.string.TxTUserRole);
       item3.value=mContext.getStr(R.string.TxTManager);
       list.add(item3);
       SettingItem1 item4=new SettingItem1();
       item4.name=mContext.getStr(R.string.TxTUserName);
       item4.value=bean.getName();
       list.add(item4);
       SettingItem1 item5=new SettingItem1();
       item5.name=mContext.getStr(R.string.TxTUserContact);
       item5.value=bean.getContact();
       list.add(item5);
       SettingItem2  item6=new SettingItem2();
       item6.name=mContext.getStr(R.string.TxTUserSafe);
       list.add(item6);
       SettingItem3 item7=new SettingItem3();
       item7.name=mContext.getStr(R.string.TxTUpdatePassword);
       list.add(item7);
       SettingItem2 item8=new SettingItem2();
       item8.name=mContext.getStr(R.string.TxTStoreMessage);
       list.add(item8);
       SettingItem1 item9=new SettingItem1();
       item9.name=mContext.getStr(R.string.TxTStoreName);
       item9.value=bean.getStore().getName();
       list.add(item9);
       SettingItem1 item10=new SettingItem1();
       item10.name=mContext.getStr(R.string.TxTStorePhone);
       item10.value=bean.getStore().getContact();
       list.add(item10);
       SettingItem1 item11=new SettingItem1();
       item11.name=mContext.getStr(R.string.TxTStoreAddress);
       item11.value=bean.getStore().getAddress();
       list.add(item11);
       SettingItem2 item12=new SettingItem2();
       item12.name=mContext.getStr(R.string.TxTAppMessage);
       list.add(item12);
       SettingItem1 item13=new SettingItem1();
       item13.name=mContext.getStr(R.string.TxTCurrentVersion);
       item13.value= MyApplication.APP_VERSION;
       list.add(item13);
       SettingItem1 item14=new SettingItem1();
       item14.name=mContext.getStr(R.string.TxTVersionUpdate);
       item14.value= mContext.getStr(R.string.TxTNoUpdate);
       list.add(item14);
       SettingItem3 item15=new SettingItem3();
       item15.name=mContext.getStr(R.string.TxTLanguage);
       list.add(item15);

       mView.refreshView(list);
    }


}
