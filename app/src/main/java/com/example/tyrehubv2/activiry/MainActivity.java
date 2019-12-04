package com.example.tyrehubv2.activiry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tyrehubv2.MyApplication;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.callback.JsonCallback;
import com.example.tyrehubv2.model.UserDetail;
import com.example.tyrehubv2.util.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.tyrehubv2.util.KeyUtils.Assistant;
import static com.example.tyrehubv2.util.KeyUtils.Manager;
import static com.example.tyrehubv2.util.KeyUtils.Merchant;
import static com.example.tyrehubv2.util.KeyUtils.Token_key;
import static com.example.tyrehubv2.util.KeyUtils.UserPool_key;

public class MainActivity extends BaseActivity {


    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.LoginText)
    TextView LoginText;
    @BindView(R.id.SelectTXT)
    TextView SelectTXT;
    @BindView(R.id.IVMerchant)
    ImageView IVMerchant;
    @BindView(R.id.IVManager)
    ImageView IVManager;
    @BindView(R.id.IVStaff)
    ImageView IVStaff;
    @BindView(R.id.TxTMerchant)
    TextView TxTMerchant;
    @BindView(R.id.TxTManager)
    TextView TxTManager;
    @BindView(R.id.TxTStaff)
    TextView TxTStaff;

    String role = "";

    @Override
    protected void onStart() {
        super.onStart();
        autoLogin();
    }


    private void autoLogin() {
        SharedPreferences shared=getSharedPreferences(UserPool_key, Context.MODE_PRIVATE);
        String token=shared.getString(Token_key,"");
        if(!TextUtils.isEmpty(token)){
            ((MyApplication)getApplication()).mToken=token;
            OkGo.<UserDetail>get(Urls.UserDetail_Url)
                    .execute(new JsonCallback<UserDetail>(MainActivity.this) {
                        @Override
                        public void onSuccess(Response<UserDetail> response) {
                            UserDetail data=response.body();
                            if(data!=null&&data.getCode()==0){
                                getMyApplication().userData=data;
                                HomePageActivity.start(data.getData().getUser(),MainActivity.this);
                                finish();
                            }
                        }
                    });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        View.OnClickListener mSelectListener1 = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                role = "merchant";
                refreshUI();
                gotoLogin();
            }
        };
        View.OnClickListener mSelectListener2 = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                role = "manager";
                refreshUI();
                gotoLogin();
            }
        };
        View.OnClickListener mSelectListener3 = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                role = "assistant";
                refreshUI();
                gotoLogin();
            }
        };
        IVManager.setOnClickListener(mSelectListener2);
        IVMerchant.setOnClickListener(mSelectListener1);
        IVStaff.setOnClickListener(mSelectListener3);
        TxTMerchant.setOnClickListener(mSelectListener1);
        TxTManager.setOnClickListener(mSelectListener2);
        TxTStaff.setOnClickListener(mSelectListener3);

    }

    private void gotoLogin() {
        LoginActivity.Start(this, role);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void refreshUI() {
        if (TextUtils.isEmpty(role)) {
            return;
        }

        if (role.equalsIgnoreCase(Merchant)) {
            IVMerchant.setImageResource(R.mipmap.shanghuxz);
            IVManager.setImageResource(R.mipmap.dianzhang);
            IVStaff.setImageResource(R.mipmap.dianyuan);
            TxTMerchant.setTextColor(getResources().getColor(R.color.colorYellow));
            TxTManager.setTextColor(getResources().getColor(R.color.colorBlack));
            TxTStaff.setTextColor(getResources().getColor(R.color.colorBlack));
            return;
        }

        if (role.equalsIgnoreCase(Manager)) {
            IVMerchant.setImageResource(R.mipmap.shanghu);
            IVManager.setImageResource(R.mipmap.dianzhangxz);
            IVStaff.setImageResource(R.mipmap.dianyuan);
            TxTMerchant.setTextColor(getResources().getColor(R.color.colorBlack));
            TxTManager.setTextColor(getResources().getColor(R.color.colorYellow));
            TxTStaff.setTextColor(getResources().getColor(R.color.colorBlack));
            return;
        }

        if (role.equalsIgnoreCase(Assistant)) {
            IVMerchant.setImageResource(R.mipmap.shanghu);
            IVManager.setImageResource(R.mipmap.dianzhang);
            IVStaff.setImageResource(R.mipmap.dianyuanxz);
            TxTMerchant.setTextColor(getResources().getColor(R.color.colorBlack));
            TxTManager.setTextColor(getResources().getColor(R.color.colorBlack));
            TxTStaff.setTextColor(getResources().getColor(R.color.colorYellow));
            return;
        }
    }
}
