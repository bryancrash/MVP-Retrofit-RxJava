package com.nice.dome.mvp.login.model;

/**
 * Created by Administrator on 2016/11/29.
 */
public interface OnLoginListener {
    /**
     * 网络访问成功
     */
    void onSuccess();

    /**
     * 网络访问失败
     */
    void onFailure();
}
