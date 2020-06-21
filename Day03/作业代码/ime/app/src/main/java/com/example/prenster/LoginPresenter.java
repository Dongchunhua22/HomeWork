package com.example.prenster;


import com.example.model.LoginModel;

public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginModel mLoginModel;
    @Override
    protected void initModel() {
        mLoginModel = new LoginModel();
        addmodel(mLoginModel);

    }

    public  void  login(String name,String pw){
        mLoginModel.login(name,pw, new ResutCallback<LoginBean>() {
            @Override
            public void onsuccess(LoginBean loginBean) {
                if (loginBean.getErrno() == Constants.SUCCESS_CODE){
                    //请求成功,并不代表登录成功
                    if (loginBean.getData().getCode() == 200) {
                        //登录成功,保存用户的信息
                        saveUserInfo(loginBean);
                        mView.loginSuccess(loginBean);
                    }else {
                        mView.showToast(loginBean.getData().getMsg());
                    }
                }

            }

            @Override
            public void onfail(String msg) {

            }
        });
    }

    private void saveUserInfo(LoginBean loginBean) {
        SpUtil.setParam(Constants.TOKEN,loginBean.getData().getToken());
        SpUtil.setParam(Constants.USERNAME,loginBean.getData().getUserInfo().getNickname());
    }
}
