package com.nice.dome.mvp.login.view;

/**
 * Created by Administrator on 2016/11/29.
 */
public interface ILoginView {
    /**
     * 登陆成功进入界面
     */
    void entryHome();

    /**
     * Toast
     */
    void toast(String msg);

    /**
     * 获取输入的用户名
     */
    String getName();

    /**
     * 获取输入的密码
     */
    String getPwd();
}
