package com.nice.dome.mvp.login.presenter;

import android.content.Context;

import com.nice.dome.mvp.login.model.ILoginModel;
import com.nice.dome.mvp.login.model.LoginModel;
import com.nice.dome.mvp.login.model.OnLoginListener;
import com.nice.dome.mvp.login.view.ILoginView;

/**
 * Created by Administrator on 2016/11/29.
 */
public class LoginPresenter implements OnLoginListener {

    ILoginModel loginModel;
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    /**
     * 登陆的方法。连接m和v
     */
    public void login() {
        if (loginView.getName().isEmpty() || loginView.getPwd().isEmpty()) {
            loginView.toast("账户密码不能为空");
            return;
        }
        String name =loginView.getName();
        String pwd = loginView.getPwd();
        loginModel.login((Context) loginView,name,pwd, this);
    }


    @Override
    public void onSuccess() {
        //成功进入其他界面
        loginView.entryHome();
    }

    @Override
    public void onFailure() {
        //失败可提示用户
        loginView.toast("登陆失败");
    }
}
