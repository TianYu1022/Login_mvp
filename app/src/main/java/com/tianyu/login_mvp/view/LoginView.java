package com.tianyu.login_mvp.view;

import com.tianyu.login_mvp.bean.LoginBean;

public interface LoginView {
    void onSuccess(LoginBean loginBean);

    void onFail(String error);
}
