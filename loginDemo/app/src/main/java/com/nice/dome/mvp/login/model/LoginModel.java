package com.nice.dome.mvp.login.model;

import android.content.Context;

import com.nice.dome.mvp.api.HttpOneMethods;
import com.nice.dome.mvp.bean.HttpResult;
import com.nice.dome.mvp.subscribers.ProgressSubscriber;
import com.nice.dome.mvp.subscribers.SubscriberOnNextListener;

/**
 * Created by Administrator on 2016/11/29.
 * 登陆的业务逻辑和model
 */
public class LoginModel implements ILoginModel {


    @Override
    public void login(Context context, String name, String pwd, final OnLoginListener onLoginListener) {
        SubscriberOnNextListener loginOnNext = new SubscriberOnNextListener<HttpResult>() {
            @Override
            public void onNext(HttpResult httpResult) {
                //message 1表示成功，其他表示失败
                if (httpResult.getMessage().equals("1")) {
                    if (onLoginListener != null)
                        onLoginListener.onSuccess();
                }else {
                    if (onLoginListener != null)
                        onLoginListener.onFailure();
                }
            }
        };

        HttpOneMethods.getInstance().login(new ProgressSubscriber(loginOnNext, context,false), name, pwd);
    }




}
