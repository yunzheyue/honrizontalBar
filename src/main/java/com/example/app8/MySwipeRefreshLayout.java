package com.example.app8;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * autour : lbing
 * date : 2018/7/30 0030 16:34
 * className :
 * version : 1.0
 * description :
 */
public class MySwipeRefreshLayout extends SwipeRefreshLayout {

    private int mTouchSlop;
    // 上一次触摸时的X坐标
    private float mPrevX;
    private float dispatchTouchX = 0;
    private float dispatchTouchY = 0;
    private List<View> allChildViews;

    public MySwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 触发移动事件的最短距离，如果小于这个距离就不触发移动控件
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //当xmL加载完毕后，计算所有的子view
        allChildViews = getAllChildViews(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TAG", "MySwipeRefreshLayout===dispatchTouchEvent==" + ev.getAction());
        int dispatchCurrX = (int) ev.getX();
        int dispatchCurrY = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //父容器不拦截点击事件，子控件拦截点击事件。如果不设置为true,外层会直接拦截，从而导致motionEvent为cancle
                getParent().requestDisallowInterceptTouchEvent(true);
                dispatchTouchX = getX();
                dispatchTouchY = getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaX = dispatchCurrX - dispatchTouchX;
                float deltaY = dispatchCurrY - dispatchTouchY;
                if (Math.abs(deltaX) - Math.abs(deltaY) >0) {//竖直滑动的父容器拦截事件
                    //进行遍历的所有的子view，进行判断是或否有当前的横向移动的view
                    for (int i = 0; i < allChildViews.size(); i++) {
                        //如果查询到当前的view是横向滑动的view，那么就判断当前时候进行滑动
                        if (allChildViews.get(i) instanceof MyBarChartView) {
                            MyBarChartView myBarChartView = (MyBarChartView) allChildViews.get(i);
                            boolean isMove = myBarChartView.isMove();
                            Log.e("TAG", "isMove===" + isMove);
                            //如果正在滑动，那么就能判断当前的view是哪个，然后获取到当前的view是否已经达到边界，然后进行判断
                            if(isMove){
                                boolean boundary = myBarChartView.isBoundary();
                                Log.e("TAG", "boundary===" + boundary);
                                if (boundary) {
                                    Log.e("TAG", "拦截1");
                                    getParent().requestDisallowInterceptTouchEvent(false);
                                } else {
                                    Log.e("TAG", "不拦截");
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                }
                                break;

                            }else{
                                Log.e("TAG", "拦截2");
                                getParent().requestDisallowInterceptTouchEvent(false);
                            }
                        } else {
                            Log.e("TAG", "拦截3");
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }

                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        dispatchTouchX = dispatchCurrX;
        dispatchTouchY = dispatchCurrY;
        return super.dispatchTouchEvent(ev);
    }

    //查询所有的控件
    private List<View> getAllChildViews(View view) {
        List<View> allchildren = new ArrayList<View>();
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                allchildren.add(viewchild);
                //再次 调用本身（递归）
                allchildren.addAll(getAllChildViews(viewchild));
            }
        }
        return allchildren;
    }


    //进一步做一个处理，但是效果并不明显
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPrevX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                final float eventX = event.getX();
                float xDiff = Math.abs(eventX - mPrevX);
                // Log.d("refresh" ,"move----" + eventX + "   " + mPrevX + "   " + mTouchSlop);
                // 增加60的容差，让下拉刷新在竖直滑动时就可以触发
                if (xDiff > mTouchSlop + 60) {
                    return false;
                }
        }

        return super.onInterceptTouchEvent(event);
    }
}