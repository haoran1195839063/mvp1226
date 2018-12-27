package haoran.bwie.com.mvp1226.view;

import haoran.bwie.com.mvp1226.entity.UserEntity;

public interface ILoginView {
    void mobileError(String msg);//用户名错误

    void pwdError(String msg);//密码错误

    void failure(String msg);//请求失败

    void success(UserEntity userEntity);//请求成功 数据合法

    void successMsg(String msg);//请求成功但数据不合法
}
