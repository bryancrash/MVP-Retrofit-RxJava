package com.nice.dome.mvp.bean;

import android.os.Parcel;

import java.io.Serializable;

public class HttpResult<T> implements Serializable {


    //非常重要的Data
    private T list;
    //非常重要的Data 旧接口的返回形式是data，新接口是list
    private T data;
    //旧接口的返回形式是data，新接口是list
    private T product;

    //登录返回的数据message
    private String message;
    private String tokenId;
    private String userId;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    protected HttpResult(Parcel in) {
        message = in.readString();
    }

    public T getList() {
        return list;
    }

    public T getData() {return data;}

    public T getProduct() {return product;}

    public String getMessage() {
        return message;
    }



}
