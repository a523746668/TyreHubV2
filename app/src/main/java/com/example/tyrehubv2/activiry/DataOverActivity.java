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
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.HomeToolbar;

import com.example.tyrehubv2.fragment.AllDataFragment;
import com.example.tyrehubv2.fragment.ChanceDataFragment;
import com.example.tyrehubv2.fragment.TransferDataFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


//数据总览
public class DataOverActivity extends BaseActivity {
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
    private List<TabItem> tabItems = new ArrayList<>(3);
    private List<TabItem> mTimes=new ArrayList<>();
    private TabItem mSelectTab;
    private TabItem mSelectTime;
    private TabItem mSelectStore;
    private MultiTypeAdapter mTimeAdater;

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
    }

    private void initTimeRecyclerview() {

    }

    private void initTabLayout() {
        TabItem item1 = new TabItem();
        item1.name = getStr(R.string.TxTDataOver);
        item1.value = "chance";
        TabItem item2 = new TabItem();
        item2.name = getStr(R.string.TxTDetailData);
        item2.value = "total";
        TabItem item3 = new TabItem();
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
                TabItem item= (TabItem) tab.getTag();
                getSelectTabData(item);

            }

            @Override
            public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {

            }
        });


    }

    private void getSelectTabData(TabItem item) {
        TabItem item1 = new TabItem();
        item1.name = getStr(R.string.TxTToday);
        item1.value = "today";
        mTimes.add(item1);
        TabItem item2 = new TabItem();
        item2.name = getStr(R.string.TxTYesterday);
        item2.value = "yesterday";
        mTimes.add(item2);

        TabItem item3 = new TabItem();
        item3.name = getStr(R.string.TxTWeek);
        item3.value = "week";
        mTimes.add(item3);

        TabItem item4 = new TabItem();
        item4.name = getStr(R.string.TxTMonth);
        item4.value = "month";
        mTimes.add(item4);

        TabItem item5 = new TabItem();
        item5.name = getStr(R.string.TxTLastMonth);
        item5.value = "last_month";
        mTimes.add(item5);

        TabItem item6 = new TabItem();
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

    }

    public static class TabItem {
        public String name;
        public String value;
    }

}
