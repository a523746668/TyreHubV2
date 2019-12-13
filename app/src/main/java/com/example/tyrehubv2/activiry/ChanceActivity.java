package com.example.tyrehubv2.activiry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.drakeet.multitype.MultiTypeAdapter;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.HomeToolbar;
import com.example.tyrehubv2.View.binder.ChanceBinder;
import com.example.tyrehubv2.activiry.View.ChanceView;
import com.example.tyrehubv2.activiry.present.ChancePresenter;
import com.example.tyrehubv2.model.ChanceModel;
import com.example.tyrehubv2.recycler.ChanceItemDecoration;
import com.google.android.material.tabs.TabLayout;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ChanceActivity extends BaseActivity implements ChanceView {


    @BindView(R.id.TitleBar)
    HomeToolbar TitleBar;
    @BindView(R.id.TabLayout)
    TabLayout TabLayout;
    @BindView(R.id.RecyclerView)
    SwipeRecyclerView RecyclerView;
    @BindView(R.id.TVRemind)
    TextView TVRemind;

    private List<TabItem> tabItems = new ArrayList<>(3);
    private MultiTypeAdapter mAdapter = new MultiTypeAdapter();
    private List<ChanceModel.DataBean.ReportsBean> mChances = new ArrayList<>();
    private String mStatus = "chance";
    private ChancePresenter mPresenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, ChanceActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chance);
        ButterKnife.bind(this);
        initTabLayout();
        initRecyclerView();
        mPresenter = new ChancePresenter(this, ChanceActivity.this);
        mPresenter.getChanceData(mStatus);
    }

    private void initRecyclerView() {
        mAdapter.register(ChanceModel.DataBean.ReportsBean.class, new ChanceBinder(getMyApplication().userData.getData().getUser().getStore().getId()+""));
        mAdapter.setItems(mChances);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.addItemDecoration(new ChanceItemDecoration());
        RecyclerView.setAdapter(mAdapter);

    }

    private void initTabLayout() {
        TabItem item1 = new TabItem();
        item1.name = getStr(R.string.TxTSaleChance);
        item1.value = "chance";
        TabItem item2 = new TabItem();
        item2.name = getStr(R.string.TxTTrackingChance);
        item2.value = "track";
        TabItem item3 = new TabItem();
        item3.name = getStr(R.string.TxTFinishedChance);
        item3.value = "finished";
        tabItems.add(item1);
        tabItems.add(item2);
        tabItems.add(item3);
        for (int i = 0; i < tabItems.size(); i++) {
            TabLayout.Tab tab = TabLayout.newTab();
            tab.setText(tabItems.get(i).name);
            tab.setTag(tabItems.get(i));
            if (i == 0) {
                TabLayout.addTab(tab, 0, true);
            } else {
                TabLayout.addTab(tab);
            }
        }

        TabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
                TabItem item= (TabItem) tab.getTag();
                if(item.value.equalsIgnoreCase(mStatus)){
                    return;
                }
               mStatus=item.value;
               mPresenter.getChanceData(mStatus);

            }

            @Override
            public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void refreshRecyclerview(List<ChanceModel.DataBean.ReportsBean> list) {
        mChances.clear();
        mChances.addAll(list);
        mAdapter.notifyDataSetChanged();
        RecyclerView.setVisibility(View.VISIBLE);
        TVRemind.setVisibility(View.GONE);
    }

    @Override
    public void refreshNoData() {
        RecyclerView.setVisibility(View.GONE);
        TVRemind.setVisibility(View.VISIBLE);
    }


    public static class TabItem {
        public String name;
        public String value;
    }
}
