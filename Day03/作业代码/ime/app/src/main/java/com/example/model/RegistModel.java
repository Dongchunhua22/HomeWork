package com.example.model;



import com.example.base.BaseModel;

import retrofit2.http.HTTP;

public class RegistModel  extends BaseModel {
    public void getData(String name, String pass, final ResutCallback<RegisterBean> callback) {
        addDisposable(
                HttpUtil
                .getInstance()
                .getApiService()
                .register(name,pass)
                .compose(RxUtils.<RegisterBean>rxSchedulerHelper())
                .subscribeWith(new ResultSubScriber<RegisterBean>() {
                    @Override
                    protected void onSuccess(RegisterBean registerBean) {
                        callback.onsuccess(registerBean);
                    }
                })
        );

    }
}
