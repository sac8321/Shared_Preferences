package com.example.proyecto_pc.my_login.App;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by JORGE-PC on 29/01/2018.
 */

public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
