package com.example.tyrehubv2.View.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.binder.item.SettingItem3;

import org.jetbrains.annotations.NotNull;

public class SettingBinder3 extends ItemViewBinder<SettingItem3, SettingBinder3.SettingViewHolder3> {


    @Override
    public void onBindViewHolder(@NotNull SettingViewHolder3 settingViewHolder3, SettingItem3 settingItem3) {
                 settingViewHolder3.name.setText(settingItem3.name);
    }

    @NotNull
    @Override
    public SettingViewHolder3 onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.setting_item3,viewGroup,false);
        return new SettingBinder3.SettingViewHolder3(root);
    }

    static class SettingViewHolder3 extends RecyclerView.ViewHolder {
        public TextView name;
        SettingViewHolder3(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
