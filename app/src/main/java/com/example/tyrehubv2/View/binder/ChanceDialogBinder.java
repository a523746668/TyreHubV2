package com.example.tyrehubv2.View.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.CircleLine;
import com.example.tyrehubv2.callback.BinderClickListener;
import com.example.tyrehubv2.dialog.ChanceDealDialog;

import org.jetbrains.annotations.NotNull;

public class ChanceDialogBinder extends ItemViewBinder<ChanceDealDialog.Item, ChanceDialogBinder.ChanceDialogViewHolder> {
    public ChanceDialogBinder(BinderClickListener<ChanceDealDialog.Item> itemBinderClickListener) {
        this.itemBinderClickListener = itemBinderClickListener;
    }

    private BinderClickListener<ChanceDealDialog.Item> itemBinderClickListener;



    @Override
    public void onBindViewHolder(@NotNull ChanceDialogViewHolder chanceDialogViewHolder, ChanceDealDialog.Item item) {
                          chanceDialogViewHolder.name.setText(item.name);
                          if(item.selected) {
                               chanceDialogViewHolder.icon.setImageResource(R.mipmap._selected);
                               chanceDialogViewHolder.itemView.setBackgroundColor(chanceDialogViewHolder.icon.getContext().getResources().getColor(R.color.colorYellow));
                          }else {
                              chanceDialogViewHolder.icon.setImageResource(R.mipmap._default);
                              chanceDialogViewHolder.itemView.setBackgroundColor(chanceDialogViewHolder.icon.getContext().getResources().getColor(R.color.colorBlack));
                          }
                          chanceDialogViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                   itemBinderClickListener.clickItem(item);
                              }
                          });

    }

    @NotNull
    @Override
    public ChanceDialogViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {

          View view=layoutInflater.inflate(R.layout.chance_spinner_item, viewGroup,false);
          return new ChanceDialogViewHolder(view);
    }

    static class ChanceDialogViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView icon;

        ChanceDialogViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.TvName);
            icon=itemView.findViewById(R.id.IvIcon);
        }
    }
}
