package com.example.tyrehubv2.dialog.view;

import com.example.tyrehubv2.dialog.ChanceDealDialog;
import com.example.tyrehubv2.model.DealDataModel;

import java.util.List;

public interface ChanceDialogView {
      void getDealManSuccess(List<ChanceDealDialog.Item> list);
      void saveDataSuccess();
      void getDealDataSuccess(DealDataModel data);
}
