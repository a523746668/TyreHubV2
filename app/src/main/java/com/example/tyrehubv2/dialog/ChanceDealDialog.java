package com.example.tyrehubv2.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.example.tyrehubv2.R;
import com.example.tyrehubv2.adapter.ChanceDialogSpinnerAdapter;
import com.example.tyrehubv2.util.KeyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChanceDealDialog extends Dialog {
    @BindView(R.id.SpStatus)
    Spinner SpStatus;

    private String chanceId;
    private String status= KeyUtils.Chance_Track;


    public ChanceDealDialog(@NonNull Context context) {
        super(context, R.style.exit_cast_activity_style);
    }

    public ChanceDealDialog(@NonNull Context context, String chanceId) {
        super(context);
        this.chanceId = chanceId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chance_deal_dialog);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

        List<Item> list=new ArrayList<>();
        Item track=new Item();
        track.name=getContext().getString(R.string.TxTTrackingChance);
        track.value=KeyUtils.Chance_Track;
        list.add(track);
        Item finish=new Item();
        finish.name=getContext().getString(R.string.TxTFinishedChance);
        finish.value=KeyUtils.Chance_Finish;
        list.add(finish);
        ChanceDialogSpinnerAdapter adapter=new ChanceDialogSpinnerAdapter(list,getContext());
        SpStatus.setAdapter(adapter);
        SpStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 status=list.get(i).name;
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


    public static class Item {
        public String name;
        public String value;
    }
}
