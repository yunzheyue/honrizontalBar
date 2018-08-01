package com.example.app8;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * autour : lbing
 * date : 2018/7/30 0030 17:23
 * className :
 * version : 1.0
 * description :
 */


public class MyViewPager extends ViewPager {

    private boolean firstInto = true;

    public MyViewPager(Context context) {
        this(context, null);
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
        Log.e("TAG", "MyViewPager===onInterceptTouchEvent==" + ev.getAction());
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (firstInto) {
                firstInto = false;
                Log.e("TAG", "MyViewPager===onInterceptTouchEvent--进行赋值前==" + getSuperField(this, "mLastMotionX"));
                setSuperField(this, "mLastMotionX", ev.getX());
                setSuperField(this, "mInitialMotionX", ev.getX());
                setSuperField(this, "mLastMotionY", ev.getY());
                setSuperField(this, "mInitialMotionY", ev.getY());
                setSuperField(this, "mIsUnableToDrag", false);
                setSuperField(this, "mIsScrollStarted", true);
                setSuperField(this, "mActivePointerId", ev.getPointerId(0));
                Scroller mScroller = (Scroller) getSuperField(this, "mScroller");
                mScroller.computeScrollOffset();
                Log.e("TAG", "MyViewPager===onInterceptTouchEvent--进行赋值后==" + getSuperField(this, "mLastMotionX"));
            }
        } else if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            firstInto = true;
        }

        return super.onInterceptTouchEvent(ev);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
//            if (firstInto) {
//                firstInto = false;
//                ((Scroller) getSuperField(this, "mScroller")).abortAnimation();
//                setSuperField(this, "mPopulatePending", false);
//
//                //1.根据方法名和方法参数获取方法对象
//                Method method = null;
//                try {
//                    method = this.getClass().getSuperclass().getDeclaredMethod("populate");
//                    //2.取消访问检查，是访问私有方法的关键
//                    method.setAccessible(true);
//                    Log.e("TAG", "MyViewPager===method===" + method.getName());
//                    //3.调用私有方法并获得返回值
//                    Constructor<?> constructor = this.getClass().getSuperclass().getConstructor(new Class[]{Context.class});
//                    ViewPager clazz1 = (ViewPager) constructor.newInstance(new Object[]{getContext()});//创建的实例
//                    method.invoke(clazz1);
//                    Log.e("TAG", "MyViewPager===method===调用成功");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                Log.e("TAG", "MyViewPager===第一次进入修改前为==" + (float) (getSuperField(this, "mLastMotionX")));
//                setSuperField(this, "mLastMotionX", ev.getX());
//                setSuperField(this, "mInitialMotionX", ev.getX());
//                setSuperField(this, "mLastMotionY", ev.getY());
//                setSuperField(this, "mInitialMotionY", ev.getY());
//                setSuperField(this, "mActivePointerId", ev.getPointerId(0));
//
//                Log.e("TAG", "MyViewPager===第一次进入修改值为==" + ev.getX() + "  " + getSuperField(this, "mLastMotionX"));
//            }
//        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
//            firstInto = true;
////            setSuperField(this, "mLastMotionX", ev.getX());
//        }
//
//        return super.onTouchEvent(ev);
//    }

    public static Object getSuperField(Object paramClass, String paramString) {
        Field field = null;
        Object object = null;
        try {
            field = paramClass.getClass().getSuperclass().getDeclaredField(paramString);
            field.setAccessible(true);
            object = field.get(paramClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void setSuperField(Object paramClass, String paramString,
                                     Object newClass) {
        Field field = null;
        try {
            field = paramClass.getClass().getSuperclass().getDeclaredField(paramString);
            field.setAccessible(true);
            field.set(paramClass, newClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e("TAG", "MyViewPager===onTouchEvent==" + ev.getAction());
        return super.onTouchEvent(ev);
    }
}
