package com.example.tyrehubv2.activiry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.HomeToolbar;

import com.example.tyrehubv2.View.binder.item.DropBinder;
import com.example.tyrehubv2.activiry.View.DataOverView;
import com.example.tyrehubv2.activiry.present.DataOverPresenter;
import com.example.tyrehubv2.callback.BinderClickListener;
import com.example.tyrehubv2.fragment.AllDataFragment;
import com.example.tyrehubv2.fragment.ChanceDataFragment;
import com.example.tyrehubv2.fragment.TransferDataFragment;
import com.example.tyrehubv2.model.AllDataModel;
import com.example.tyrehubv2.model.DetailDataModel;
import com.example.tyrehubv2.model.Item;
import com.example.tyrehubv2.model.TransformDetailModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


//数据总览
public class DataOverActivity extends BaseActivity  implements DataOverView{
    @BindView(R.id.TitleBar)
    HomeToolbar TitleBar;
    @BindView(R.id.TVSelectTime)
    TextView TVSelectTime;
    @BindView(R.id.TVCheckRate)
    TextView TVCheckRate;
    @BindView(R.id.TVFindChanceRate)
    TextView TVFindChanceRate;
    @BindView(R.id.TVTrackChanceRate)
    TextView TVTrackChanceRate;
    @BindView(R.id.TVTransferRate)
    TextView TVTransferRate;
    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.mFragmentLayout)
    FrameLayout mFragmentLayout;
    private AllDataFragment mAllDataFragment;
    private ChanceDataFragment mChanceDataFragment;
    private TransferDataFragment mTransferDataFragment;
    private FragmentManager fragmentManager;//定义一个fragmentManager
    private List<Item> tabItems = new ArrayList<>(3);
    private List<Item> mTimes=new ArrayList<>();
    private Item mSelectTab;
    private Item mSelectTime;
    private Item mSelectStore;
    private MultiTypeAdapter mTimeAdater;
    private DataOverPresenter mPresenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, DataOverActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_over);
        ButterKnife.bind(this);
        initTabLayout();
        initTimeRecyclerview();

        TitleBar.setBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initFragment();

        mPresenter=new DataOverPresenter(this,this);
        mPresenter.getTotalDataForTime(mSelectTime);
    }

    private void initFragment() {
         fragmentManager=getSupportFragmentManager();
         mAllDataFragment=new AllDataFragment();
         mChanceDataFragment=new ChanceDataFragment();
         mTransferDataFragment=new TransferDataFragment();
         FragmentTransaction ft=fragmentManager.beginTransaction();
         ft.add(R.id.mFragmentLayout,mAllDataFragment);
         ft.add(R.id.mFragmentLayout,mChanceDataFragment);
         ft.add(R.id.mFragmentLayout,mTransferDataFragment);
         ft.show(mAllDataFragment);
         ft.hide(mChanceDataFragment);
         ft.hide(mTransferDataFragment);
         ft.commit();

    }


    private void initTabLayout() {
        Item item1 = new Item();
        item1.name = getStr(R.string.TxTDataOver);
        item1.value = "total";
        mSelectTab=item1;
        Item item2 = new Item();
        item2.name = getStr(R.string.TxTDetailData);
        item2.value = "chance";
        Item item3 = new Item();
        item3.name = getStr(R.string.TxTTransferData);
        item3.value = "transeform";
        tabItems.add(item1);
        tabItems.add(item2);
        tabItems.add(item3);
        for (int i = 0; i < tabItems.size(); i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(tabItems.get(i).name);
            tab.setTag(tabItems.get(i));
            if (i == 0) {
                mTabLayout.addTab(tab, 0, true);
            } else {
                mTabLayout.addTab(tab);
            }
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
                Item item= (Item) tab.getTag();
                if(item.value.equalsIgnoreCase(mSelectTab.value)) return;
                mSelectTab=item;
                FragmentTransaction ft=fragmentManager.beginTransaction();
                if(item.value.equalsIgnoreCase("total")){
                    ft.show(mAllDataFragment);
                    ft.hide(mChanceDataFragment);
                    ft.hide(mTransferDataFragment);
                    ft.commit();
                }else if(item.value.equalsIgnoreCase("chance")){
                    ft.hide(mAllDataFragment);
                    ft.show(mChanceDataFragment);
                    ft.hide(mTransferDataFragment);
                    ft.commit();
                }else {
                    ft.hide(mAllDataFragment);
                    ft.hide(mChanceDataFragment);
                    ft.show(mTransferDataFragment);
                    ft.commit();
                }

            }

            @Override
            public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {

            }
        });


    }


    private void initTimeRecyclerview() {

        Item item1 = new Item();
        item1.name = getStr(R.string.TxTToday);
        item1.value = "today";
        mSelectTime=item1;
        mTimes.add(item1);
        Item item2 = new Item();
        item2.name = getStr(R.string.TxTYesterday);
        item2.value = "yesterday";
        mTimes.add(item2);

        Item item3 = new Item();
        item3.name = getStr(R.string.TxTWeek);
        item3.value = "week";
        mTimes.add(item3);

        Item item4 = new Item();
        item4.name = getStr(R.string.TxTMonth);
        item4.value = "month";
        mTimes.add(item4);

        Item item5 = new Item();
        item5.name = getStr(R.string.TxTLastMonth);
        item5.value = "last_month";
        mTimes.add(item5);

        Item item6 = new Item();
        item6.name = getStr(R.string.TxTYear);
        item6.value = "year";
        mTimes.add(item6);

        PopupWindow timeWindow=new PopupWindow();
        TVSelectTime.post(new Runnable() {
            @Override
            public void run() {
                timeWindow.setWidth(TVSelectTime.getWidth());
                timeWindow.setHeight(TVSelectTime.getHeight()*6);
            }
        });

        View contentview= LayoutInflater.from(DataOverActivity.this).inflate(R.layout.chancepop,null);
        RecyclerView recyclerView=contentview.findViewById(R.id.popRecyclerview);
        mTimeAdater=new MultiTypeAdapter();
        mTimeAdater.register(com.example.tyrehubv2.model.Item.class,new DropBinder(new BinderClickListener<com.example.tyrehubv2.model.Item>() {
            @Override
            public void clickItem(com.example.tyrehubv2.model.Item data) {
                refreshItemList(data,mTimes);
                mSelectTime=data;
                mTimeAdater.notifyDataSetChanged();
                TVSelectTime.setText(mSelectTime.name);
                timeWindow.dismiss();

            }
        }));
        mTimeAdater.setItems(mTimes);
        recyclerView.setLayoutManager(new LinearLayoutManager(DataOverActivity.this));
        recyclerView.setAdapter(mTimeAdater);
        timeWindow.setContentView(contentview);
        TVSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(timeWindow.isShowing()) {
                    timeWindow.dismiss();
                 }else {
                     timeWindow.showAsDropDown(TVSelectTime);
                 }
            }
        });
    }


    private void getSelectTabData(Item item) {




    }


    public void refreshItemList(Item data, List<Item> list){
        for(Item item:list){
            if(item.value.equalsIgnoreCase(data.value)){
                item.selected=true;
            }else {
                item.selected=false;
            }
        }

    }

    public String calculate100(int i,int j){
        return            (int)(i/j *100) +"%";

    }


    @Override
    public void getAllDataSuccess(AllDataModel data) {
        if(data.data!=null){

        }

    }

    @Override
    public void getChanceDataSuccess(DetailDataModel data) {

    }

    @Override
    public void getTransferDataSuccess(TransformDetailModel data) {

    }

    @Override
    public void getTransferTrendDataSuccess(AllDataModel data) {

    }
}
