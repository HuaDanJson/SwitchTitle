package com.example.jason.switchonepanimation;

import android.app.Application;

/**
 * Created by jason on 2018/1/22.
 */

public class CCApplication extends Application {

    private static CCApplication INSTANCE;

    public static CCApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
