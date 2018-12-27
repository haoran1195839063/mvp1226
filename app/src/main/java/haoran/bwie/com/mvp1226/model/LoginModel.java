package haoran.bwie.com.mvp1226.model;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import haoran.bwie.com.mvp1226.api.UserApi;
import haoran.bwie.com.mvp1226.entity.UserEntity;
import haoran.bwie.com.mvp1226.net.RequestCallBack;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements ILoginModel {
    private Handler handler = new Handler();

    @Override
    public void login(HashMap<String, String> params, final RequestCallBack requestCallBack) {

        //okhttp网络框架的管理类
        OkHttpClient okHttpClient = new OkHttpClient();
        //对请求体，构建数据的过程，建造者模式
        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String, String> h : params.entrySet()) {
            formBody.add(h.getKey(), h.getValue());
        }
        //创建请求信息对象
        Request build = new Request.Builder().url(UserApi.LoginInterface).post(formBody.build()).build();
        //创建请求执行对象
        Call call = okHttpClient.newCall(build);
        //异步请求
        call.enqueue(new Callback() {
            //失败的话 回调接口失败的方法里
            @Override
            public void onFailure(final Call call, IOException e) {
                if (requestCallBack != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallBack.failure("网络可能不稳定，请稍后再试");
                        }
                    });
                }
            }

            //如果成功  获取响应体
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                int code = response.code();
                if (!TextUtils.isEmpty(string)) {
                    paserResult(string, requestCallBack, code);
                }
            }

            //gson解析后存入callback接口里
            private void paserResult(String string, final RequestCallBack requestCallBack, int code) {
                final UserEntity userEntity = new Gson().fromJson(string, UserEntity.class);
                if (requestCallBack != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallBack.success(userEntity);
                        }
                    });
                }
            }
        });

    }

}
