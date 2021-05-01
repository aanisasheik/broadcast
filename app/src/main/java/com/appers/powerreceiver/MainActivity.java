package com.appers.powerreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand=new Random();
private CustomReciever mReciever=new CustomReciever();
private static final String ACTION_CUSTOM_BROADCAST=BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(mReciever,filter);

        LocalBroadcastManager.getInstance(this).registerReceiver(mReciever,new IntentFilter(ACTION_CUSTOM_BROADCAST));

    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReciever);
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReciever);
    }

    public void sendCustomBroadcast(View view ) {
        int num=rand.nextInt(20);
Intent customBroadcastIntent=new Intent();
customBroadcastIntent.setAction(ACTION_CUSTOM_BROADCAST);
customBroadcastIntent.putExtra("randomNum",num);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}