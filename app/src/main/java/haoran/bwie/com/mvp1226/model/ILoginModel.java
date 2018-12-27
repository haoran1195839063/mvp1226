package haoran.bwie.com.mvp1226.model;

import java.util.HashMap;

import haoran.bwie.com.mvp1226.net.RequestCallBack;

public interface ILoginModel {
    void login(HashMap<String,String> params,RequestCallBack requestCallback);
}
