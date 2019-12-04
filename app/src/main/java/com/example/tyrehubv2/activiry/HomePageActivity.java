package com.example.tyrehubv2.activiry;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import com.example.tyrehubv2.R;
import com.example.tyrehubv2.activiry.View.HomePageView;
import com.example.tyrehubv2.activiry.present.HomePagePresenter;
import com.example.tyrehubv2.model.UserDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.tyrehubv2.util.KeyUtils.UserData_Key;

public class HomePageActivity extends BaseActivity implements HomePageView {

    @BindView(R.id.TvName)
    TextView TvName;
    @BindView(R.id.CardDataAll)
    CardView CardDataAll;
    @BindView(R.id.TvRole)
    TextView TvRole;
    @BindView(R.id.TVRedCircle)
    TextView TVRedCircle;
    @BindView(R.id.CardChance)
    CardView CardChance;
    @BindView(R.id.CardDevice)
    CardView CardDevice;
    @BindView(R.id.CardRecord)
    CardView CardRecord;
    @BindView(R.id.CardSetting)
    CardView CardSetting;
    @BindView(R.id.CardStaffManager)
    CardView CardStaffManager;

    private HomePagePresenter mPresenter;

    public static void start(UserDetail.DataBean.UserBean data, BaseActivity activity) {
        Intent intent = new Intent(activity, HomePageActivity.class);
        intent.putExtra(UserData_Key, data);
        activity.startActivity(intent);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);
        initView();
        mPresenter = new HomePagePresenter(this, this);
        mPresenter.getUnreadCount();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("WrongConstant")
    private void initView() {
        GradientDrawable drawable = new GradientDrawable();
        //设置外形为为矩形
        drawable.setShape(GradientDrawable.RECTANGLE);
        //设置外形为为矩形,同上一句功能一致
        drawable.setGradientType(GradientDrawable.RECTANGLE);
        //设置圆角角度
        drawable.setCornerRadius(12);
        //设置背景色
        drawable.setColor(getResources().getColor(R.color.colorPrimary));
        TvRole.setTextColor(getResources().getColor(R.color.colorWhite));
        TvRole.setBackground(drawable);
        CardDataAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePageActivity.this, "-----", 0).show();
            }
        });

        CardChance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChanceActivity.start(HomePageActivity.this);
            }
        });
        CardSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingActivity.start(HomePageActivity.this);
            }
        });
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getStr(R.string.TxTTyrehub))
                .setMessage(getStr(R.string.TxTCloseAppTs))
                .setPositiveButton(getStr(R.string.TxTSure), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                      finishApp();
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


    @Override
    public void refreshCount(int value) {
        if (value > 0) {
            TVRedCircle.setVisibility(View.VISIBLE);
            if (value > 9) {
                TVRedCircle.setText("···");
            } else {
                TVRedCircle.setText(String.valueOf(value));
            }
        } else {
            TVRedCircle.setVisibility(View.GONE);
        }

    }
}
