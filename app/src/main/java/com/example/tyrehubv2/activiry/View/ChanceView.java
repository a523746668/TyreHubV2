package com.example.tyrehubv2.activiry.View;

import com.example.tyrehubv2.model.ChanceModel;

import java.util.List;

public interface ChanceView {
   void   refreshRecyclerview(List<ChanceModel.DataBean.ReportsBean> list);
   void   refreshNoData();
}
