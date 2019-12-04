package com.example.tyrehubv2.activiry;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.HomeToolbar;
import com.example.tyrehubv2.View.binder.SettingBinder1;
import com.example.tyrehubv2.View.binder.SettingBinder2;
import com.example.tyrehubv2.View.binder.SettingBinder3;
import com.example.tyrehubv2.View.binder.item.SettingItem1;
import com.example.tyrehubv2.View.binder.item.SettingItem2;
import com.example.tyrehubv2.View.binder.item.SettingItem3;
import com.example.tyrehubv2.activiry.View.SettingView;
import com.example.tyrehubv2.activiry.present.SettingPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.tyrehubv2.util.KeyUtils.Token_key;
import static com.example.tyrehubv2.util.KeyUtils.UserPool_key;

public class SettingActivity extends BaseActivity implements SettingView {


    @BindView(R.id.RecyclerView)
    RecyclerView RecyclerView;
    @BindView(R.id.TitleBar)
    HomeToolbar TitleBar;
    @BindView(R.id.TVLoginOut)
    TextView TVLoginOut;

    private MultiTypeAdapter mAdapter = new MultiTypeAdapter();
    private List<Object> mItems = new ArrayList<>();
    private SettingPresenter mPresenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initRecyclerView();
        mPresenter = new SettingPresenter(this, this);
        mPresenter.dealData();
        TVLoginOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    LoginOut();
            }
        });

    }

    private void initRecyclerView() {
        mAdapter.register(SettingItem1.class, new SettingBinder1());
        mAdapter.register(SettingItem2.class, new SettingBinder2());
        mAdapter.register(SettingItem3.class, new SettingBinder3());
        mAdapter.setItems(mItems);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void refreshView(List<Object> list) {
        mItems.clear();
        mItems.addAll(list);
        mAdapter.notifyDataSetChanged();
    }


    public void LoginOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getStr(R.string.TxTTyrehub))
                .setMessage(getStr(R.string.TxTCloseAppTs))
                .setPositiveButton(getStr(R.string.TxTSure), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        SharedPreferences shared=getSharedPreferences(UserPool_key, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putString(Token_key, "");
                        editor.commit();
                        Intent intent=new Intent(SettingActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(getStr(R.string.TxTCancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {

                    }
                })
                .show();
    }
}
