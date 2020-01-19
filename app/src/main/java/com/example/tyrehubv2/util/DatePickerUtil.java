package com.example.tyrehubv2.util;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentProvider;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DatePickerUtil {

    public static void showTimePickerDialog(Context activity, int themeResId, final TextView tv, String str) {
        // Calendar c = Calendar.getInstance();
        // 创建一个TimePickerDialog实例，并把它显示出来
        // 解释一哈，Activity是context的子类
        new TimePickerDialog(activity, themeResId,
                // 绑定监听器
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tv.setText(str+" "+hourOfDay+"-"+minute);
                    }
                }
                // 设置初始时间
                ,  0
                , 0
                // true表示采用24小时制
                , true).show();
    }


    public static void showDatePickerDialog(Context activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听
            // 器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作]
                monthOfYear++;
                String str=year+"-"+monthOfYear +"-"+dayOfMonth;
                showTimePickerDialog(activity,themeResId,tv,str);
            }
        }
                // 设置初始日期
                ,2018
                , 0
                , 1).show();


    }

}