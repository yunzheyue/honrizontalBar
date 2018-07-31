package com.example.app8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.app8.MyBarChartView.BarData;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList<BarData> innerData = new ArrayList<>();
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
        innerData.add(new BarData(78, "17月"));
        innerData.add(new BarData(78, "18月"));
        innerData.add(new BarData(78, "19月"));
        innerData.add(new BarData(78, "20月"));
        innerData.add(new BarData(78, "21月"));
        innerData.add(new BarData(78, "22月"));
        innerData.add(new BarData(78, "23月"));
        innerData.add(new BarData(78, "24月"));
        innerData.add(new BarData(0, "25月"));

        MyBarChartView mybarCharView = (MyBarChartView) findViewById(R.id.mybarCharView);
        mybarCharView.setBarChartData(innerData);
    }
}
