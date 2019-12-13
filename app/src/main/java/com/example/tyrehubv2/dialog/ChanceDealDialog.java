package com.example.tyrehubv2.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;

import com.example.tyrehubv2.MyApplication;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.activiry.BaseActivity;
import com.example.tyrehubv2.adapter.ChanceDialogSpinnerAdapter;
import com.example.tyrehubv2.dialog.presenter.ChanceDialogPresenter;
import com.example.tyrehubv2.dialog.view.ChanceDialogView;
import com.example.tyrehubv2.model.DealDataModel;
import com.example.tyrehubv2.util.KeyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChanceDealDialog extends Dialog implements ChanceDialogView {
    @BindView(R.id.SpStatus)
    Spinner SpStatus;
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
    Spinner SpDealMan;
    @BindView(R.id.SpResult)
    Spinner SpResult;
    @BindView(R.id.SpContent)
    Spinner SpContent;
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

        List<Item> statuList = mPresenter.getStatuList();
        ChanceDialogSpinnerAdapter adapter = new ChanceDialogSpinnerAdapter(statuList, getContext());
        SpStatus.setAdapter(adapter);
        SpStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                status = statuList.get(i);
                if(status.value.equalsIgnoreCase(KeyUtils.Chance_Track)){
                    GroupTrack.setVisibility(View.VISIBLE);
                    GroupFinish.setVisibility(View.GONE);
                }else  {
                    GroupTrack.setVisibility(View.GONE);
                    GroupFinish.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        List<Item>  results=mPresenter.getResultList();

        ChanceDialogSpinnerAdapter resultAdapter = new ChanceDialogSpinnerAdapter(results, getContext());
        SpResult.setAdapter(resultAdapter);
        SpResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                   result=results.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        List<Item>  contents=mPresenter.getContentList();
        ChanceDialogSpinnerAdapter contentAdapte=new ChanceDialogSpinnerAdapter(contents,getContext());
        SpContent.setAdapter(contentAdapte);
        SpContent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                     content=contents.get(i) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
        ChanceDialogSpinnerAdapter dealadapter =new ChanceDialogSpinnerAdapter(list,getContext());
        SpDealMan.setAdapter(dealadapter);
        SpDealMan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    dealman=list.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
    }
}
