package com.example.andreperloti.implementationrv;


import android.app.Application;

import com.example.andreperloti.implementationrv.util.ApplicationUtil;

/**
 * Created by andre.perloti on 19/02/2016.
 */


public class ApplicationManager extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtil.setContext(getApplicationContext());
    }

}
