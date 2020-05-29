package com.tianyu.login_mvp.model;

import com.tianyu.login_mvp.api.ApiService;
import com.tianyu.login_mvp.bean.LoginBean;
import com.tianyu.login_mvp.callback.LoginCallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpLoginModel implements LoginModel {
    @Override
    public void login(String username, String password, LoginCallback loginCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.baseLoginUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<LoginBean> observable = apiService.login(username, password);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (loginBean.getErrorCode() == 0) {
                            loginCallback.onSuccess(loginBean);
                        } else {
                            loginCallback.onFail(loginBean.getErrorMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginCallback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
