package com.example.tyrehubv2.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.tyrehubv2.R;

public class HomeToolbar extends Toolbar {

    private LayoutInflater inflater;

    private View view;

    private EditText editText;

    private TextView tv;

    private Button button;

    private ImageView imageView;



    //右边图标

    private int bitresouce;



    private Bitmap bitmap;





    public HomeToolbar(Context context) {

        super(context);

        init(context);

    }



    public HomeToolbar(Context context, AttributeSet attrs) {

        super(context, attrs);

        init(context);

        if (attrs!=null){

            TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.HomeToolbar);


            String title=array.getString(R.styleable.HomeToolbar_title);
            tv.setText(title);

            if(bitresouce!=0){

                setrighticon(bitresouce);

            }
            array.recycle();

        }



    }



    private void init(Context context) {

        if(view==null){

            inflater=LayoutInflater.from(context);

            view=inflater.inflate(R.layout.titlebar,null);

            tv = (TextView) view.findViewById(R.id.toolbar_title);

            LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);

            addView(view,params);



        }







    }









    public void showTitleView(){

        if(tv !=null)

            tv.setVisibility(VISIBLE);

    }





    public void hideTitleView() {

        if (tv != null)

            tv.setVisibility(GONE);

    }



    @Override

    public void setTitle(int resId) {



        setTitle(getContext().getText(resId));

    }







    //重写settitle，让title属性赋值到我们的textview上面去

    @Override

    public void setTitle(CharSequence title) {



        init(getContext());

        if(tv !=null) {

            tv.setText(title);

            showTitleView();

        }

    }



    public void setrighttext(String text){

        button.setText(text);

    }











    //控制editext的显示

    public  void showSearchView(){



        if(editText !=null)

            editText.setVisibility(VISIBLE);



    }





    public void hideSearchView(){

        if(editText !=null)

            editText.setVisibility(GONE);

    }









    //对右边button的控制

    public void setRightButtonText(CharSequence text){



        button.setText(text);

        button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        button.setVisibility(VISIBLE);

    }



    public  void setRightButtonOnClickListener(OnClickListener li){



        button.setOnClickListener(li);

    }

    public void setrighticon(int resouce){

        //  Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.icon_add);

        button.setBackgroundResource(resouce);

        button.setVisibility(VISIBLE);

    }

}
