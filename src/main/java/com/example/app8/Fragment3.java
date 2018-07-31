package com.example.app8;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app8.MyBarChartView.BarData;

import java.util.ArrayList;

/**
 * autour : lbing
 * date : 2018/7/30 0030 15:02
 * className :
 * version : 1.0
 * description :
 */


public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<BarData> innerData = new ArrayList<>();
        innerData.add(new BarData(0, "1月"));
        innerData.add(new BarData(14, "2月"));
        innerData.add(new BarData(43, "3月"));
        innerData.add(new BarData(35, "4月"));
        innerData.add(new BarData(56, "5月"));
        innerData.add(new BarData(12, "6月"));
        innerData.add(new BarData(142, "7月"));
        innerData.add(new BarData(121, "8月"));
        innerData.add(new BarData(102, "9月"));
        innerData.add(new BarData(238, "10月"));
        innerData.add(new BarData(18, "11月"));
        innerData.add(new BarData(348, "12月"));
        innerData.add(new BarData(8, "13月"));
        innerData.add(new BarData(258, "14月"));
        innerData.add(new BarData(168, "15月"));
        innerData.add(new BarData(258, "16月"));
        innerData.add(new BarData(168, "17月"));

        View view = inflater.inflate(R.layout.fragment3, container, false);
        MyBarChartView mybarCharView = (MyBarChartView) view.findViewById(R.id.mybarCharView);
        Button next = (Button) view.findViewById(R.id.next);
        mybarCharView.setBarChartData(innerData);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Main2Activity.class));
            }
        });

        return view;
    }
}
