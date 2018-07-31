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


public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<BarData> innerData = new ArrayList<>();
        innerData.add(new BarData(120, "1月"));
        innerData.add(new BarData(124, "2月"));
        innerData.add(new BarData(423, "3月"));
        innerData.add(new BarData(325, "4月"));
        innerData.add(new BarData(526, "5月"));
        innerData.add(new BarData(122, "6月"));
        innerData.add(new BarData(142, "7月"));
        innerData.add(new BarData(121, "8月"));
        innerData.add(new BarData(102, "9月"));
        innerData.add(new BarData(238, "10月"));
        innerData.add(new BarData(18, "11月"));
        innerData.add(new BarData(348, "12月"));
        innerData.add(new BarData(82, "13月"));
        innerData.add(new BarData(258, "14月"));
        innerData.add(new BarData(168, "15月"));
        innerData.add(new BarData(258, "16月"));
        innerData.add(new BarData(168, "17月"));
        View view = inflater.inflate(R.layout.fragment2, container, false);
        MyBarChartView mybarCharView = (MyBarChartView) view.findViewById(R.id.mybarCharView);
        mybarCharView.setBarChartData(innerData);
        return view;
    }
}
