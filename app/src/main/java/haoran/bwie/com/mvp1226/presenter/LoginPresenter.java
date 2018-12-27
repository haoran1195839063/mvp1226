package haoran.bwie.com.mvp1226.presenter;

import java.util.HashMap;

import haoran.bwie.com.mvp1226.entity.UserEntity;
import haoran.bwie.com.mvp1226.model.ILoginModel;
import haoran.bwie.com.mvp1226.model.LoginModel;
import haoran.bwie.com.mvp1226.net.RequestCallBack;
import haoran.bwie.com.mvp1226.view.ILoginView;

public class LoginPresenter {
    private ILoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    public void login(HashMap<String, String> param) {

        String mobile = "18612991023";
        String password = "11111111";
        if (loginModel != null) {
            loginModel.login(param, new RequestCallBack() {
                @Override
                public void failure(String msg) {
                    loginView.failure(msg);
                }

                @Override
                public void successMsg(String msg) {
                    loginView.successMsg(msg);
                }

                @Override
                public void success(UserEntity userEntity) {
                    loginView.success(userEntity);
                }
            });
        }

    }
}
