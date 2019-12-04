package com.example.tyrehubv2.activiry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyrehubv2.Manifest;
import com.example.tyrehubv2.MyApplication;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.ColorFiltButton;
import com.example.tyrehubv2.View.ColorFiltImageView;
import com.example.tyrehubv2.View.ColorFilterTextView;
import com.example.tyrehubv2.callback.JsonCallback;
import com.example.tyrehubv2.model.LoginModel;
import com.example.tyrehubv2.model.UserDetail;
import com.example.tyrehubv2.util.Urls;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

import static com.example.tyrehubv2.util.KeyUtils.Role_Key;
import static com.example.tyrehubv2.util.KeyUtils.Token_key;
import static com.example.tyrehubv2.util.KeyUtils.UserPool_key;


@RuntimePermissions
public class LoginActivity extends BaseActivity {



    @BindView(R.id.IVPhone)
    ImageView IVPhone;
    @BindView(R.id.ETPhone)
    EditText ETPhone;
    @BindView(R.id.IVPassword)
    ImageView IVPassword;
    @BindView(R.id.ETPassword)
    EditText ETPassword;
    @BindView(R.id.TVLoginBtn)
    TextView TVLoginBtn;
    @BindView(R.id.TVRegister)
    ColorFilterTextView TVRegister;
    @BindView(R.id.TVForget)
    ColorFilterTextView TVForget;

    @BindView(R.id.logo)
    ColorFiltImageView logo;

    public String mRole;


    public static void Start(AppCompatActivity activity, String role) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra(Role_Key, role);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        mRole = getIntent().getStringExtra(Role_Key);
    }

    private void initView() {
        TVLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               LoginActivityPermissionsDispatcher.LoginWithPermissionCheck(LoginActivity.this);
            }
        });
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("tmd","0--");
            }
        });

        TVRegister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        TVRegister.getPaint().setAntiAlias(true);//抗锯齿
        TVForget.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        TVForget.getPaint().setAntiAlias(true);//抗锯齿
    }


    @NeedsPermission(Manifest.permission.INTERNET)
    public  void Login() {
        if (TextUtils.isEmpty(ETPhone.getText()) || TextUtils.isEmpty(ETPassword.getText())) {

            return;
        }
        String acount = ETPhone.getText().toString();
        String password = ETPassword.getText().toString();

        JSONObject object=new JSONObject();

        try {
            object.put("role",mRole);
            object.put("username", acount);
            object.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        OkGo.<LoginModel>put(Urls.Login_Url)
                .upJson(object)
                .execute(new JsonCallback<LoginModel>(LoginActivity.this) {

                    @Override
                    public void onSuccess(Response<LoginModel> response) {
                        LoginModel model=response.body();
                        if(model!=null&&model.getCode()==0){
                            ((MyApplication)getApplication()).mToken=model.getData().getToken();
                            SharedPreferences shared=getSharedPreferences(UserPool_key, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = shared.edit();
                            editor.putString(Token_key, model.getData().getToken());
                            editor.commit();
                            getUser();
                        }
                    }
                });
    }

    private void getUser() {
        OkGo.<UserDetail>get(Urls.UserDetail_Url)
             .execute(new JsonCallback<UserDetail>(LoginActivity.this) {
                 @Override
                 public void onSuccess(Response<UserDetail> response) {
                       UserDetail data=response.body();
                       if(data!=null&&data.getCode()==0){
                           getMyApplication().userData=data;
                           HomePageActivity.start(data.getData().getUser(),LoginActivity.this);
                       }
                 }
             });

    }
}
