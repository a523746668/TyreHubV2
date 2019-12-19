package com.example.tyrehubv2.dialog.presenter;

import android.content.Context;

import com.example.tyrehubv2.R;
import com.example.tyrehubv2.callback.JsonCallback;
import com.example.tyrehubv2.dialog.ChanceDealDialog;
import com.example.tyrehubv2.dialog.view.ChanceDialogView;
import com.example.tyrehubv2.model.DealDataModel;
import com.example.tyrehubv2.model.DealManModel;
import com.example.tyrehubv2.util.KeyUtils;
import com.example.tyrehubv2.util.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class ChanceDialogPresenter {
       private Context mContext;
       private ChanceDialogView mView;

    public ChanceDialogPresenter(Context mContext, ChanceDialogView mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    public void getDealManList(String  StoreId){
        OkGo.<DealManModel>get(Urls.Chance_Dialog_DealMan_Url)
                           .params("store_id",StoreId)
                           .execute(new JsonCallback<DealManModel>(false,mContext) {
                               @Override
                               public void onSuccess(Response<DealManModel> response) {
                                     DealManModel model=response.body();
                                    if(model.code==0&&model.data!=null&&model.data.staffs!=null){
                                         List<ChanceDealDialog.Item> list=new ArrayList<>();
                                        for(DealManModel.DataBean.StaffsBean bean :model.data.staffs){
                                            ChanceDealDialog.Item  item=new ChanceDealDialog.Item();
                                            item.name=bean.name;
                                            item.value=String.valueOf(bean.id);
                                            list.add(item);
                                          }
                                        mView.getDealManSuccess(list);
                                    }
                               }
                           });

    }

     public void getChanceDealData(String chanceId){
           OkGo.<DealDataModel>get(Urls.Chance_Dialog_DealData_Url)
                   .params("report_id",chanceId)
                   .execute(new JsonCallback<DealDataModel>(false,mContext) {
                       @Override
                       public void onSuccess(Response<DealDataModel> response) {
                              DealDataModel model=response.body();
                              if(model.code==0){
                                 mView.getDealDataSuccess(model);
                              }
                       }
                   });
     }


    public List<ChanceDealDialog.Item> getStatuList(){

        List<ChanceDealDialog.Item> list = new ArrayList<>();
        ChanceDealDialog.Item track = new ChanceDealDialog.Item();
        track.name = mContext.getString(R.string.TxTTrackingChance);
        track.value = KeyUtils.Chance_Track;
        list.add(track);
        ChanceDealDialog.Item finish = new ChanceDealDialog.Item();
        finish.name = mContext.getString(R.string.TxTFinishedChance);
        finish.value = KeyUtils.Chance_Finish;
        list.add(finish);

        return   list;
    }

    public List<ChanceDealDialog.Item> getResultList(){
        String []valus=getResultValue();
        List<ChanceDealDialog.Item> list = new ArrayList<>();
        ChanceDealDialog.Item item1 = new ChanceDealDialog.Item();
        item1.name = mContext.getString(R.string.TxTIntention);
        item1.value = valus[0];
        list.add(item1);
        ChanceDealDialog.Item item2 = new ChanceDealDialog.Item();
        item2.name = mContext.getString(R.string.TxTTransformed);
        item2.value = valus[1];
        list.add(item2);
        ChanceDealDialog.Item item3 = new ChanceDealDialog.Item();
        item3.name = mContext.getString(R.string.TxTFinishedChance);
        item3.value = valus[2];
        list.add(item3);

        return   list;
    }



    public List<ChanceDealDialog.Item> getContentList(){
        String []valus=getContentValue();
        List<ChanceDealDialog.Item> list = new ArrayList<>();
        ChanceDealDialog.Item item1 = new ChanceDealDialog.Item();
        item1.name = mContext.getString(R.string.TxTTire1);
        item1.value = valus[0];
        list.add(item1);
        ChanceDealDialog.Item item2 = new ChanceDealDialog.Item();
        item2.name = mContext.getString(R.string.TxTTire2);
        item2.value = valus[1];
        list.add(item2);
        ChanceDealDialog.Item item3 = new ChanceDealDialog.Item();
        item3.name = mContext.getString(R.string.TxTTire3);
        item3.value = valus[2];
        list.add(item3);

        ChanceDealDialog.Item item4 = new ChanceDealDialog.Item();
        item4.name = mContext.getString(R.string.TxTTire4);
        item4.value = valus[3];
        list.add(item4);

        ChanceDealDialog.Item item5 = new ChanceDealDialog.Item();
        item5.name = mContext.getString(R.string.TxTAlignment);
        item5.value = valus[4];
        list.add(item5);

        ChanceDealDialog.Item item6 = new ChanceDealDialog.Item();
        item6.name = mContext.getString(R.string.TxTBalance);
        item6.value = valus[5];
        list.add(item6);

        ChanceDealDialog.Item item7 = new ChanceDealDialog.Item();
        item7.name = mContext.getString(R.string.TxTOther);
        item7.value = valus[6];
        list.add(item7);

        return   list;
    }


    public String[] getResultValue(){
       String   []strs={"intention","transformed","disagree"};

       return  strs;
    }

    public String[] getContentValue(){
        String   []strs={"1-tire","2-tire","3-tire","4-tire"," 4-wheel-alignment","dynamic-balance","others"};

        return  strs;
    }

    public void refreshItemList(ChanceDealDialog.Item data, List<ChanceDealDialog.Item> list){
           for(ChanceDealDialog.Item item:list){
               if(item.value.equalsIgnoreCase(data.value)){
                   item.selected=true;
               }else {
                   item.selected=false;
               }
           }

    }


}
