package com.workstudio.wutao.imagerecognition;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            MainActivity.TestData.add("屏幕关闭");
        }
        else if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            MainActivity.TestData.add("屏幕开启");
        }
        MainActivity.ad.notifyDataSetChanged();
    }

}
