package com.nice.dome.mvp.api;

/**
 * Created by Administrator on 2016/9/21.
 */


import com.nice.dome.mvp.bean.HttpResult;

import rx.functions.Func1;

/**
 * 用来统一处理Http的resultCode,并将HttpResult返回给subscriber
 */
class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    @Override
    public T call(HttpResult<T> httpResult) {
//            if (httpResult.getResult().equals("失败")) {
//                throw new ApiException(0);
//            }
        return (T) httpResult;
    }
}