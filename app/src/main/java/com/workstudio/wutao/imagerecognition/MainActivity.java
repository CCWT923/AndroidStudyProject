package com.workstudio.wutao.imagerecognition;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Btn_Start;
    ListView ListView_Log;
    public static ArrayAdapter<String> ad;
    public static ArrayList<String> TestData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn_Start = findViewById(R.id.Btn_Start);
        Btn_Start.setOnClickListener(this);
        ListView_Log = findViewById(R.id.ListView_Log);
        ad = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,TestData);
        ListView_Log.setAdapter(ad);
        handler.postDelayed(r,100); //主线程中调用定时任务
    }

    //创建定时任务
    final Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            //TestData.add(String.valueOf(++counter));
            TestData.add(0, String.valueOf(++counter));
            ad.notifyDataSetChanged();
            //每隔1000毫秒执行run方法
            handler.postDelayed(this,1000);
        }
    };

    int counter = 0;
    public void onClick(View v)
    {
        TestData.clear();
        ad.notifyDataSetChanged();
        counter = 0;
    }

    private void registerService()
    {
        ScreenReceiver s = new ScreenReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        getApplicationContext().registerReceiver(s,filter);
    }
}

