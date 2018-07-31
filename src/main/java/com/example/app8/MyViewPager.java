package com.example.app8;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * autour : lbing
 * date : 2018/7/30 0030 17:23
 * className :
 * version : 1.0
 * description :
 */


public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        this(context,null);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.e("TAG", "MyViewPager===dispatchTouchEvent=="+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.e("TAG", "MyViewPager===onInterceptTouchEvent=="+ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }
}
