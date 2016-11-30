package com.nice.dome.mvp.login.model;

import android.content.Context;

/**
 * Created by Administrator on 2016/11/29.
 */
public interface ILoginModel {
    void login(Context context, String name, String pwd, OnLoginListener onLoginListener);
}
