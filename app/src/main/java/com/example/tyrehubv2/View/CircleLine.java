package com.example.tyrehubv2.View;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.tyrehubv2.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleLine extends LinearLayout {

    TextView TVCircle1;

    TextView TVCircle2;

    TextView TVCircle3;

    TextView TVCircle4;

    private View mView;
    private LayoutInflater inflater;
    private List<TextView> list=new ArrayList<>(4);



    public CircleLine(Context context) {
        super(context);
        init(context);

    }


    public CircleLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);


    }


    private void init(Context context) {

        if (mView == null) {

            inflater = LayoutInflater.from(context);

            mView = inflater.inflate(R.layout.circle_line, null);
            TVCircle1=mView.findViewById(R.id.TVCircle1);
            TVCircle2=mView.findViewById(R.id.TVCircle2);
            TVCircle3=mView.findViewById(R.id.TVCircle3);
            TVCircle4=mView.findViewById(R.id.TVCircle4);

            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.LEFT);

            addView(mView, params);
             list.add(TVCircle1);
             list.add(TVCircle2);
             list.add(TVCircle3);
             list.add(TVCircle4);
        }
    }



    public void setColor(List<String> colors){
         for(int i=0;i<colors.size();i++){
             String colorstr=colors.get(i);
             int color;
             if(colorstr.equalsIgnoreCase("low")){
                 color=getContext().getResources().getColor(R.color.colorGreen);
             }else if(colorstr.equalsIgnoreCase("high")){
                  color=getContext().getResources().getColor(R.color.colorRed);
             }else {
                 color=getContext().getResources().getColor(R.color.colorYellow);
             }
             TextView tv=list.get(i);
             GradientDrawable drawable=new GradientDrawable();
             drawable.setShape(GradientDrawable.OVAL);
             drawable.setColor(color);
             tv.setBackgroundDrawable(drawable);

         }

    }



}
