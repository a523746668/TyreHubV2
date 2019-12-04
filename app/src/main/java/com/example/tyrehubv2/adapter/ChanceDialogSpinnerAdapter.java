package com.example.tyrehubv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tyrehubv2.R;
import com.example.tyrehubv2.dialog.ChanceDealDialog;

import org.w3c.dom.Text;

import java.util.List;

public class ChanceDialogSpinnerAdapter extends BaseAdapter {
    private List<ChanceDealDialog.Item> mList;
    private Context mContext;

    public ChanceDialogSpinnerAdapter(List<ChanceDealDialog.Item> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater _LayoutInflater=LayoutInflater.from(mContext);
        view=_LayoutInflater.inflate(R.layout.chance_spinner_item, null);

        if(view!=null){
            TextView tv =(TextView)view.findViewById(R.id.TvName);
            tv.setText(mList.get(i).name);
        }
        return view;

    }
}
