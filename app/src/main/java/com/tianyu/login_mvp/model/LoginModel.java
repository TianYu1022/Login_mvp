package com.tianyu.login_mvp.model;

import com.tianyu.login_mvp.callback.LoginCallback;

public interface LoginModel {
    void login(String username, String password, LoginCallback loginCallback);
}
