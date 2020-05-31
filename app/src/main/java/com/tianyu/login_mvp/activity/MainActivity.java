package com.tianyu.login_mvp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tianyu.login_mvp.R;
import com.tianyu.login_mvp.bean.LoginBean;
import com.tianyu.login_mvp.presenter.ImpLoginPresenter;
import com.tianyu.login_mvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private Button btn_login;
    private EditText et_pass;
    private EditText et_name;
    private Button btn_register;

    // TODO: 2020/5/31  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_login = (Button) findViewById(R.id.btn_login);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_name = (EditText) findViewById(R.id.et_name);

        btn_login.setOnClickListener(this);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_register:
                Toast.makeText(this, "注册按钮", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void login() {
        String pass = et_pass.getText().toString().trim();
        String name = et_name.getText().toString().trim();
        new ImpLoginPresenter(this).login(name, pass);
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
