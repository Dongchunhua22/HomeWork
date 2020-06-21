package com.example.model;


import com.example.base.BaseModel;

public class LoginModel extends BaseModel {
    public void login(String name, String pw, final ResutCallback<LoginBean> callback) {
        addDisposable(
                HttpUtil.getInstance()
                .getApiService()
                .login(name,pw)
                .compose(RxUtils.<LoginBean>rxSchedulerHelper())
                .subscribeWith(new ResultSubScriber<LoginBean>() {
                    @Override
                    protected void onSuccess(LoginBean loginBean) {
                        callback.onsuccess(loginBean);
                    }
                })
        );

    }
}
