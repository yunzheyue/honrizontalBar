package com.example.app8;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * autour : lbing
 * date : 2018/7/30 0030 18:51
 * className :
 * version : 1.0
 * description :
 */


public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
