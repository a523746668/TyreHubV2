package com.example.tyrehubv2.View.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.binder.item.SettingItem1;

import org.jetbrains.annotations.NotNull;

public class SettingBinder1 extends ItemViewBinder<SettingItem1, SettingBinder1.SettingViewHolder1> {


    @Override
    public void onBindViewHolder(@NotNull SettingViewHolder1 settingViewHolder1, SettingItem1 settingItem1) {
                    settingViewHolder1.name.setText(settingItem1.name);
                    settingViewHolder1.value.setText(settingItem1.value);
    }

    @NotNull
    @Override
    public SettingViewHolder1 onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
         View root=layoutInflater.inflate(R.layout.setting_item1,viewGroup,false);
        return new SettingViewHolder1(root);
    }

    static class SettingViewHolder1 extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView value;
        SettingViewHolder1(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            value=itemView.findViewById(R.id.value);
        }
    }
}
