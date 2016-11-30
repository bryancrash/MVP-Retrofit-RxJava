package com.nice.dome.mvp.api;


import com.nice.dome.mvp.bean.HttpResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface RetrofitService {
    //登录
    @FormUrlEncoded
    @POST("member/yonghuApi/login")
    Observable<HttpResult> login(@Field("mobile") String userName, @Field("password") String password);
}