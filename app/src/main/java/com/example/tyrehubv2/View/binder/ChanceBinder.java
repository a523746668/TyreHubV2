package com.example.tyrehubv2.View.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.example.tyrehubv2.R;
import com.example.tyrehubv2.View.CircleLine;
import com.example.tyrehubv2.dialog.ChanceDealDialog;
import com.example.tyrehubv2.model.ChanceModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ChanceBinder extends ItemViewBinder<ChanceModel.DataBean.ReportsBean, ChanceBinder.ChanceViewHolder> {

    private String store_id;
    private String chanceStatu;

    public ChanceBinder(String store_id, String chanceStatu) {
        this.store_id = store_id;
        this.chanceStatu = chanceStatu;
    }

    public ChanceBinder(String store_id) {
        this.store_id = store_id;
    }

    @Override
    public void onBindViewHolder(@NotNull ChanceViewHolder viewHolder, ChanceModel.DataBean.ReportsBean reportsBean) {
        viewHolder.numbers.setText(reportsBean.plate_no);
        String time=reportsBean.create_time.replace("T"," ");
        viewHolder.times.setText(time);
        List<String> wear = new ArrayList<>();
        wear.add(reportsBean.wear_lf_degree);
        wear.add(reportsBean.wear_rf_degree);
        wear.add(reportsBean.wear_rb_degree);
        wear.add(reportsBean.wear_lb_degree);
        viewHolder.wear.setColor(wear);
        List<String> wears = new ArrayList<>();
        wears.add(reportsBean.ecc_wear_lf_degree);
        wears.add(reportsBean.ecc_wear_rf_degree);
        wears.add(reportsBean.ecc_wear_rb_degree);
        wears.add(reportsBean.ecc_wear_lb_degree);
        viewHolder.wears.setColor(wears);
        viewHolder.deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  new ChanceDealDialog(view.getContext(),String.valueOf(reportsBean.id),store_id,chanceStatu=="chance"?true:false).show();
            }
        });


    }

    @NotNull
    @Override
    public ChanceViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        View root = layoutInflater.inflate(R.layout.chance_item, viewGroup, false);
        return new ChanceViewHolder(root);
    }

    static class ChanceViewHolder extends RecyclerView.ViewHolder {
        public CircleLine wear, wears;
        public TextView times, numbers,deal,report;

        ChanceViewHolder(@NonNull View itemView) {
            super(itemView);
            wear = itemView.findViewById(R.id.LineWear);
            wears = itemView.findViewById(R.id.LineWears);
            times = itemView.findViewById(R.id.TVtimes);
            numbers = itemView.findViewById(R.id.TVnumbers);
            deal=itemView.findViewById(R.id.TVDeal);
            report=itemView.findViewById(R.id.TVReport);
            report.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
