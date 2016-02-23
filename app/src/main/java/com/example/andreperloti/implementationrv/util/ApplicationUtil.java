package com.example.andreperloti.implementationrv.util;

import android.content.Context;

/**
 * Created by andre.perloti on 19/02/2016.
 */
public class ApplicationUtil {

    private static Context context;

    private ApplicationUtil(){
        super();
    }

    public static void  setContext(Context context){
        ApplicationUtil.context = context;
    }

    public static Context getContext(){
        return ApplicationUtil.context;
    }

}