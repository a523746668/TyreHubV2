package com.example.tyrehubv2.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.example.tyrehubv2.MyApplication;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.binder.ChanceDialogBinder;
import com.example.tyrehubv2.activiry.BaseActivity;
import com.example.tyrehubv2.adapter.ChanceDialogSpinnerAdapter;
import com.example.tyrehubv2.bean.ChanceDialogUpBean;
import com.example.tyrehubv2.callback.BinderClickListener;
import com.example.tyrehubv2.dialog.presenter.ChanceDialogPresenter;
import com.example.tyrehubv2.dialog.view.ChanceDialogView;
import com.example.tyrehubv2.model.DealDataModel;
import com.example.tyrehubv2.util.DatePickerUtil;
import com.example.tyrehubv2.util.KeyUtils;
import com.lzy.okgo.cookie.store.SPCookieStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChanceDealDialog extends Dialog implements ChanceDialogView {
    @BindView(R.id.SpStatus)
    TextView SpStatus;
    @BindView(R.id.GroupFinish)
    Group GroupFinish;
    @BindView(R.id.GroupTrack)
    Group GroupTrack;
    @BindView(R.id.TVCancel)
    TextView TVCancel;
    @BindView(R.id.TVUpdate)
    TextView TVUpdate;
    @BindView(R.id.TVSure)
    TextView TVSure;
    @BindView(R.id.EtArea)
    EditText EtArea;
    @BindView(R.id.SpDealMan)
    TextView SpDealMan;
    @BindView(R.id.SpResult)
    TextView SpResult;
    @BindView(R.id.SpContent)
    TextView SpContent;
    @BindView(R.id.TVIntent)
    TextView TVIntent;
    @BindView(R.id.ETPrice)
    EditText ETPrice;
    @BindView(R.id.TVTransferTime)
    TextView TVTransferTime;

    private String chanceId;
    private String store_id;
    private Item status ;
    private ChanceDialogPresenter mPresenter;
    private Item result;
    private Item content;
    private Item dealman;
    private BaseActivity mBaseActivity;
    private boolean isChance=false; //是否是销售机会
    private String price="";
    private  List<Item> statuList ,contents,results;
    private  MultiTypeAdapter statuAdapter,mcontentAdapter,resultAdapter;
    public ChanceDealDialog(@NonNull Context context) {
        super(context, R.style.exit_cast_activity_style);
    }

    public ChanceDealDialog(@NonNull Context context, String chanceId, String store_id,boolean isChance) {
        super(context,R.style.exit_cast_activity_style);
        this.chanceId = chanceId;
        this.store_id = store_id;
        this.isChance=isChance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chance_deal_dialog);
        ButterKnife.bind(this);


        mPresenter=new ChanceDialogPresenter(getContext(),this);
        initView();
        initData();
        mPresenter.getDealManList(store_id);
        if(!isChance){
            mPresenter.getChanceDealData(chanceId);
        }

    }

    private void initView() {
        TVCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ChanceDealDialog.this.dismiss();
            }
        });

        TVIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerUtil.showDatePickerDialog(getContext(), AlertDialog.THEME_HOLO_LIGHT,TVIntent, Calendar.getInstance(Locale.CHINA));
            }
        });

        TVTransferTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerUtil.showDatePickerDialog(getContext(),AlertDialog.THEME_HOLO_LIGHT,TVTransferTime,Calendar.getInstance(Locale.CHINA));
            }
        });
        View.OnClickListener submit=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  SubmitInformation();
            }
        };
        TVSure.setOnClickListener(submit);
        TVUpdate.setOnClickListener(submit);

    }

    private void SubmitInformation() {
         if(status==null||dealman==null||result==null||content==null){
            return;
         }
         ChanceDialogUpBean data=new ChanceDialogUpBean();
         data.status=status.value;
         data.area=EtArea.getText()+"";
         data.report_id=chanceId;
         data.manage_staff=dealman.name;
         data.results=result.value;
         data.change_type=content.value;
         data.change_amount=price;
         data.changed_time=TVTransferTime.getText()+"";
         data.intention_time=TVIntent.getText()+"";
         mPresenter.SubmitChanceInformation(data);

    }

    private void initData() {
        LayoutInflater inflater=LayoutInflater.from(getContext());

        initSpstatu(inflater);

        initSpresult(inflater);

        initSpcontent(inflater);


    }

    private void initSpcontent(LayoutInflater inflater) {
        contents=mPresenter.getContentList();
        PopupWindow contentWindow=new PopupWindow();
        SpContent.post(new Runnable() {

            @Override
            public void run() {
                contentWindow.setWidth(SpContent.getWidth());
                contentWindow.setHeight(SpContent.getHeight()*contents.size());
            }
        });
        View contentview= inflater.inflate(R.layout.chancepop,null);
        RecyclerView mRecyclerview=contentview.findViewById(R.id.popRecyclerview);
        mcontentAdapter=new MultiTypeAdapter();
        mcontentAdapter.register(Item.class,new ChanceDialogBinder(new BinderClickListener<Item>() {
            @Override
            public void clickItem(Item data) {
                mPresenter.refreshItemList(data,contents);
                mcontentAdapter.notifyDataSetChanged();
                contentWindow.dismiss();
                content=data;
                SpContent.setText(data.name);
            }
        }));
        mcontentAdapter.setItems(contents);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerview.setAdapter(mcontentAdapter);
        contentWindow.setContentView(contentview);
        SpContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contentWindow.isShowing()) {
                    contentWindow.dismiss();
                }else {
                    contentWindow.showAsDropDown(SpContent);
                }
            }
        });
    }

    private void initSpresult(LayoutInflater inflater) {
     results=mPresenter.getResultList();
        PopupWindow resultWindow=new PopupWindow();
        SpResult.post(new Runnable() {
            @Override
            public void run() {
                resultWindow.setWidth(SpResult.getWidth());
                resultWindow.setHeight(SpResult.getHeight()*results.size());
            }
        });
        View contentview= inflater.inflate(R.layout.chancepop,null);
        RecyclerView resultRecyclerview=contentview.findViewById(R.id.popRecyclerview);
        resultAdapter=new MultiTypeAdapter();
        resultAdapter.register(Item.class,new ChanceDialogBinder(new BinderClickListener<Item>() {
            @Override
            public void clickItem(Item data) {
                mPresenter.refreshItemList(data,results);
                resultAdapter.notifyDataSetChanged();
                resultWindow.dismiss();
                result=data;
                SpResult.setText(data.name);
            }
        }));
        resultAdapter.setItems(results);
        resultRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        resultRecyclerview.setAdapter(resultAdapter);
        resultWindow.setContentView(contentview);
        SpResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultWindow.isShowing()) {
                    resultWindow.dismiss();
                }else {
                    resultWindow.showAsDropDown(SpResult);
                }
            }
        });
    }

    private void initSpstatu(LayoutInflater inflater) {
        statuList = mPresenter.getStatuList();

        PopupWindow statuWindow=new PopupWindow();

        SpStatus.post(new Runnable() {
            @Override
            public void run() {
                statuWindow.setWidth(SpStatus.getWidth());
                statuWindow.setHeight(SpStatus.getHeight()*2+10);
            }
        });
        View contentview= inflater.inflate(R.layout.chancepop,null);
        RecyclerView statuRecyclerview=contentview.findViewById(R.id.popRecyclerview);
         statuAdapter=new MultiTypeAdapter();
        statuAdapter.register(Item.class,new ChanceDialogBinder(new BinderClickListener<Item>() {
            @Override
            public void clickItem(Item data) {
                if(data.value.equalsIgnoreCase(KeyUtils.Chance_Track)){
                    GroupTrack.setVisibility(View.VISIBLE);
                    GroupFinish.setVisibility(View.GONE);
                }else {
                    GroupFinish.setVisibility(View.VISIBLE);
                    GroupTrack.setVisibility(View.GONE);
                }
                mPresenter.refreshItemList(data,statuList);
                statuAdapter.notifyDataSetChanged();
                statuWindow.dismiss();
                status=data;
                SpStatus.setText(data.name);
            }
        }));
        statuAdapter.setItems(statuList);
        statuRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        statuRecyclerview.setAdapter(statuAdapter);
        statuWindow.setContentView(contentview);

        SpStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statuWindow.isShowing()) {
                    statuWindow.dismiss();
                }else {
                    statuWindow.showAsDropDown(SpStatus);
                }
            }
        });
    }


    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setAttributes(layoutParams);
    }

    @Override
    public void getDealManSuccess(List<Item> list) {
        List<Item>  items=list;
        PopupWindow mWindow=new PopupWindow();
        SpDealMan.post(new Runnable() {

            @Override
            public void run() {
                mWindow.setWidth(SpDealMan.getWidth());
                mWindow.setHeight(SpDealMan.getHeight()*items.size());
            }
        });
        View contentview= LayoutInflater.from(getContext()).inflate(R.layout.chancepop,null);
        RecyclerView mRecyclerview=contentview.findViewById(R.id.popRecyclerview);
        MultiTypeAdapter mAdapter=new MultiTypeAdapter();
        mAdapter.register(Item.class,new ChanceDialogBinder(new BinderClickListener<Item>() {
            @Override
            public void clickItem(Item data) {
                mPresenter.refreshItemList(data,items);
                mAdapter.notifyDataSetChanged();
                mWindow.dismiss();
                dealman=data;
                SpDealMan.setText(data.name);
            }
        }));
        mAdapter.setItems(items);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerview.setAdapter(mAdapter);
        mWindow.setContentView(contentview);
        SpDealMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mWindow.isShowing()) {
                    mWindow.dismiss();
                }else {
                    mWindow.showAsDropDown(SpDealMan);
                }
            }
        });
    }

    @Override
    public void saveDataSuccess() {

    }

    @Override
    public void getDealDataSuccess(DealDataModel data) {
            DealDataModel.DataBean.ChanceBean bean= data.data.chance;
             if(bean.status==null){
                 this.dismiss();
                 return;
             }

       status=new Item();
       status.value=bean.status;
       status.name= bean.status.equalsIgnoreCase(KeyUtils.Chance_Track)? getContext().getString(R.string.TxTTrackingChance):getContext().getString(R.string.TxTFinishedChance);
       mPresenter.refreshItemList(status,statuList);
       statuAdapter.notifyDataSetChanged();
       SpStatus.setText(status.name);

       result=new Item();
       result.value=bean.results;
       result.name=result.value.equalsIgnoreCase("intention")?getstr(R.string.TxTIntention):result.value.equalsIgnoreCase("transformed")?getstr(R.string.TxTTransformed): getstr(R.string.TxTDisagree);
       mPresenter.refreshItemList(result,results);
       resultAdapter.notifyDataSetChanged();
       SpResult.setText(result.name);

       content=new Item();
       content.value=bean.change_type;
       content.name= mPresenter.Itemname(content.value,contents);
       mPresenter.refreshItemList(content,contents);
       mcontentAdapter.notifyDataSetChanged();
       SpContent.setText(content.name);


    }

    public String  getstr(int rid){
         return  getContext().getString(rid);
    }

    @Override
    public void SubmitDataSuccess() {
        this.dismiss();
    }


    public static class Item {
        public String name;
        public String value;
        public boolean selected=false;
    }
}
