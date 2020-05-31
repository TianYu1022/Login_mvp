package com.tianyu.login_mvp.presenter;

import android.text.TextUtils;

import com.tianyu.login_mvp.bean.LoginBean;
import com.tianyu.login_mvp.callback.LoginCallback;
import com.tianyu.login_mvp.model.ImpLoginModel;
import com.tianyu.login_mvp.view.LoginView;

public class ImpLoginPresenter implements LoginPresenter, LoginCallback {
    private ImpLoginModel model;
    private LoginView view;

    public ImpLoginPresenter(LoginView view) {
        this.view = view;
        model = new ImpLoginModel();
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(password)) {
            view.onFail("账号不能为空");
            return;
        }

        if (TextUtils.isEmpty(username)) {
            view.onFail("密码不能为空");
            return;
        }
        model.login(username, password, this);
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        view.onSuccess(loginBean);
    }

    @Override
    public void onFail(String error) {
        view.onFail(error);
    }
}
