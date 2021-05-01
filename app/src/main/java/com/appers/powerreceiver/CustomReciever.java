package com.appers.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static androidx.appcompat.widget.AppCompatDrawableManager.get;

public class CustomReciever extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST=BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
       String intentAction=intent.getAction();
       if(intentAction!=null){
          String toastMessage= "UNKNOWN INTENT ACTION";
          switch(intentAction){
              case Intent.ACTION_POWER_CONNECTED:
                  toastMessage="Power Connected!";
                  break;
              case Intent.ACTION_POWER_DISCONNECTED:
                  toastMessage="Power Disconnected!";
                  break;
              case ACTION_CUSTOM_BROADCAST:
                  toastMessage="Custom Broadcast Recievwed";
                  break;
          }
        int s=intent.getIntExtra("randomNum",0);
           Toast.makeText(context, toastMessage+ "  "+(s*s),
                    Toast.LENGTH_SHORT).show();
       }
    }
}