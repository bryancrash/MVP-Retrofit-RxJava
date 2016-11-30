package com.nice.dome.mvp.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;



/**
 * Created by jzm.
 */
public class MyApp extends Application {
    //全局上下文
    public static Context context;
    //全局的主线程，使用是无需再创建
    public static Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mainHandler = new Handler();
    }
}
