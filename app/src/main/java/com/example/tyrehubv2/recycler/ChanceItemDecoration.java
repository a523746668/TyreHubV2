package com.example.tyrehubv2.recycler;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChanceItemDecoration  extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
         outRect.left=50;
         outRect.right=50;
         outRect.bottom=25;
         if(parent.getChildAdapterPosition(view)==0){
             outRect.top=25;
         }

    }
}
