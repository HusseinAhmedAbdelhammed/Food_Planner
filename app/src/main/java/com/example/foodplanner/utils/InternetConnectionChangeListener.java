package com.example.foodplanner.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
public class InternetConnectionChangeListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(!isConnectToInternet(context)){
            Alerts.setAlert(context);
        }
    }

    public boolean isConnectToInternet(Context context){
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(manager !=null){
            NetworkInfo[] info = manager.getAllNetworkInfo();
            if(info != null){
                for(int i =0; i<info.length; i++){
                    if(info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }
}
