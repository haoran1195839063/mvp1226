package haoran.bwie.com.mvp1226.net;

import haoran.bwie.com.mvp1226.entity.UserEntity;

public interface RequestCallBack {
    void failure(String msg);//服务器请求失败：断网，服务器宕机等等因素

    void successMsg(String msg);//请求成功，但数据不正确

    void success(UserEntity userEntity);//数据合法
}
