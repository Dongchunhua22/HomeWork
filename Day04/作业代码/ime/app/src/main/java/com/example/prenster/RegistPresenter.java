package com.example.prenster;


import com.example.model.RegistModel;

public class RegistPresenter  extends BasePresenter<RegistView> {
    private RegistModel registModel;
    public void getData(String name, String pass) {
        registModel.getData(name,pass, new ResutCallback<RegisterBean>() {
            @Override
            public void onsuccess(RegisterBean registerBean) {
                int errno = registerBean.getErrno();
                if(errno==0){
                    mView.showToast("注册成功");
                }else {
                    mView.showToast(registerBean.getErrmsg());
                }
            }

            @Override
            public void onfail(String msg) {

            }
        });

    }

    @Override
    protected void initModel() {
        registModel = new RegistModel();
        addmodel(registModel);
    }
}
