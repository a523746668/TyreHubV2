package com.example.tyrehubv2.dialog;

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
import com.example.tyrehubv2.callback.BinderClickListener;
import com.example.tyrehubv2.dialog.presenter.ChanceDialogPresenter;
import com.example.tyrehubv2.dialog.view.ChanceDialogView;
import com.example.tyrehubv2.model.DealDataModel;
import com.example.tyrehubv2.util.KeyUtils;
import com.lzy.okgo.cookie.store.SPCookieStore;

import java.util.ArrayList;
import java.util.List;

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

    public ChanceDealDialog(@NonNull Context context) {
        super(context, R.style.exit_cast_activity_style);
    }

    public ChanceDealDialog(@NonNull Context context, String chanceId, String store_id) {
        super(context,R.style.exit_cast_activity_style);
        this.chanceId = chanceId;
        this.store_id = store_id;
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
        mPresenter.getChanceDealData(chanceId);
    }

    private void initView() {
        TVCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ChanceDealDialog.this.dismiss();
            }
        });

    }

    private void initData() {
        LayoutInflater inflater=LayoutInflater.from(getContext());


        initSpstatu(inflater);

        initSpresult(inflater);

        initSpcontent(inflater);








    }

    private void initSpcontent(LayoutInflater inflater) {
        List<Item>  contents=mPresenter.getContentList();
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
        MultiTypeAdapter mAdapter=new MultiTypeAdapter();
        mAdapter.register(Item.class,new ChanceDialogBinder(new BinderClickListener<Item>() {
            @Override
            public void clickItem(Item data) {
                mPresenter.refreshItemList(data,contents);
                mAdapter.notifyDataSetChanged();
                contentWindow.dismiss();
                content=data;
                SpContent.setText(data.name);
            }
        }));
        mAdapter.setItems(contents);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerview.setAdapter(mAdapter);
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
        List<Item>  results=mPresenter.getResultList();
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
        MultiTypeAdapter resultAdapter=new MultiTypeAdapter();
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
        List<Item> statuList = mPresenter.getStatuList();

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
        MultiTypeAdapter statuAdapter=new MultiTypeAdapter();
        statuAdapter.register(Item.class,new ChanceDialogBinder(new BinderClickListener<Item>() {
            @Override
            public void clickItem(Item data) {
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
                content=data;
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

    }


    public static class Item {
        public String name;
        public String value;
        public boolean selected=false;
    }
}
