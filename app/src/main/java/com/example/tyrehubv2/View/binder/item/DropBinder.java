package com.example.tyrehubv2.View.binder.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.callback.BinderClickListener;
import com.example.tyrehubv2.model.Item;

import org.jetbrains.annotations.NotNull;

public class DropBinder extends ItemViewBinder<Item, DropBinder.DropBinderViewHolder> {

    private BinderClickListener<Item> itemBinderClickListener;


    public DropBinder(BinderClickListener<Item> itemBinderClickListener) {
        this.itemBinderClickListener = itemBinderClickListener;
    }

    @Override
    public void onBindViewHolder(@NotNull DropBinderViewHolder dropBinderViewHolder, Item item) {
        dropBinderViewHolder.name.setText(item.name);
        if(item.selected) {
            dropBinderViewHolder.icon.setImageResource(R.mipmap._selected);
            dropBinderViewHolder.itemView.setBackgroundColor(dropBinderViewHolder.icon.getContext().getResources().getColor(R.color.colorYellow));
        }else {
            dropBinderViewHolder.icon.setImageResource(R.mipmap._default);
            dropBinderViewHolder.itemView.setBackgroundColor(dropBinderViewHolder.icon.getContext().getResources().getColor(R.color.colorBlack));
        }
        dropBinderViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemBinderClickListener.clickItem(item);
            }
        });
    }

    @NotNull
    @Override
    public DropBinderViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        View view=layoutInflater.inflate(R.layout.chance_spinner_item, viewGroup,false);
        return new DropBinderViewHolder(view);
    }

    static class DropBinderViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView icon;

       DropBinderViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.TvName);
            icon=itemView.findViewById(R.id.IvIcon);
        }
    }
}
