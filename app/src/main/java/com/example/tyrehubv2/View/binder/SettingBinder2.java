package com.example.tyrehubv2.View.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.binder.item.SettingItem2;

import org.jetbrains.annotations.NotNull;

public class SettingBinder2  extends ItemViewBinder<SettingItem2, SettingBinder2.SettingViewHolder2> {


    @Override
    public void onBindViewHolder(@NotNull SettingViewHolder2 settingViewHolder2, SettingItem2 settingItem2) {
        settingViewHolder2.name.setText(settingItem2.name);
    }

    @NotNull
    @Override
    public SettingViewHolder2 onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.setting_item2,viewGroup,false);
        return new SettingBinder2.SettingViewHolder2(root);
    }

    static class SettingViewHolder2 extends RecyclerView.ViewHolder {
     public TextView name;
        SettingViewHolder2(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
