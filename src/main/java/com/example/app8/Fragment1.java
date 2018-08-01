package com.example.app8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app8.MyBarChartView.BarData;

import java.util.ArrayList;

/**
 * autour : lbing
 * date : 2018/7/30 0030 15:02
 * className :
 * version : 1.0
 * description :
 */


public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        ArrayList<BarData> innerData = new ArrayList<>();
        innerData.add(new BarData(14, "1月"));
        innerData.add(new BarData(14, "2月"));
        innerData.add(new BarData(43, "3月"));
        innerData.add(new BarData(35, "4月"));
        innerData.add(new BarData(56, "5月"));
        innerData.add(new BarData(12, "6月"));
        innerData.add(new BarData(102, "9月"));
        innerData.add(new BarData(142, "7月"));
        innerData.add(new BarData(121, "8月"));
        innerData.add(new BarData(238, "10月"));
        innerData.add(new BarData(18, "11月"));
        innerData.add(new BarData(348, "12月"));
        innerData.add(new BarData(82, "13月"));
        innerData.add(new BarData(238, "14月"));
        innerData.add(new BarData(18, "15月"));
        innerData.add(new BarData(348, "16月"));
        innerData.add(new BarData(82, "17月"));

        View view = inflater.inflate(R.layout.fragment1, container, false);
        MyBarChartView mybarCharView = (MyBarChartView) view.findViewById(R.id.mybarCharView);
        MyBarChartView mybarCharView1 = (MyBarChartView) view.findViewById(R.id.mybarCharView1);
        MyBarChartView mybarCharView2 = (MyBarChartView) view.findViewById(R.id.mybarCharView2);
        mybarCharView.setBarChartData(innerData);
        mybarCharView1.setBarChartData(innerData);
//        mybarCharView2.setBarChartData(innerData);
        return view;

    }
}
