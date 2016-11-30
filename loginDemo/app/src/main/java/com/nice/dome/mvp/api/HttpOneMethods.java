package com.nice.dome.mvp.api;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/21.
 */
public class HttpOneMethods {

    /**
     * 单例
     */
    private static HttpOneMethods httpOneMethods = new HttpOneMethods();

    private HttpOneMethods() {
    }

    public static HttpOneMethods getInstance() {
        return httpOneMethods;
    }


    private RetrofitService retrofitService = HttpMethods.getInstance().retrofitService;

    /**
     * 用户登录
     */
    public void login(Subscriber subscriber, String userName, String password) {

        Observable observable = retrofitService.login(userName, password)
                .map(new HttpResultFunc());

        toSubscribe(observable, subscriber);
    }


    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
