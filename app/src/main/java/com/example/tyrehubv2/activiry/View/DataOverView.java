package com.example.tyrehubv2.activiry.View;

import com.example.tyrehubv2.model.AllDataModel;
import com.example.tyrehubv2.model.DetailDataModel;
import com.example.tyrehubv2.model.TransformDetailModel;

public interface DataOverView {

    void getAllDataSuccess(AllDataModel data);
    void getChanceDataSuccess(DetailDataModel data);
    void getTransferDataSuccess(TransformDetailModel data);
    void getTransferTrendDataSuccess(AllDataModel data);

}
