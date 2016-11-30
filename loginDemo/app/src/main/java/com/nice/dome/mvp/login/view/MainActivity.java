package com.nice.dome.mvp.login.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nice.dome.mvp.R;
import com.nice.dome.mvp.login.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText mLoginPwd;
    private EditText mLoginName;
    private LoginPresenter presenter;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static final int REQUEST_EXTERNAL_STORAGE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        configPermission();

        presenter = new LoginPresenter(this);
    }

    private void initView() {
        mLoginName = (EditText) findViewById(R.id.login_name);
        mLoginPwd = (EditText) findViewById(R.id.login_pwd);
    }

    @Override
    public void entryHome() {
        Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getName() {
        return mLoginName.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mLoginPwd.getText().toString().trim();
    }

    public void loginClick(View view) {
        presenter.login();
    }


    /**
     * 配置权限
     */
    private void configPermission() {
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
