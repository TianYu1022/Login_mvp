package com.tianyu.login_mvp.callback;

import com.tianyu.login_mvp.bean.LoginBean;

public interface LoginCallback {
    void onSuccess(LoginBean loginBean);

    void onFail(String error);
}
