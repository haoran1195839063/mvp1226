package haoran.bwie.com.mvp1226.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

import haoran.bwie.com.mvp1226.R;
import haoran.bwie.com.mvp1226.entity.UserEntity;
import haoran.bwie.com.mvp1226.presenter.LoginPresenter;
import haoran.bwie.com.mvp1226.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private Button login;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginPresenter = new LoginPresenter(this);
    }

    private void initView() {
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                login();
                break;
        }
    }

    private void login() {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", "17632819213");
        params.put("password", "123456");
        if (loginPresenter!=null)
        loginPresenter.login(params);
    }

    //view层里的方法
    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdError(String msg) {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void success(UserEntity userEntity) {
        Toast.makeText(this,userEntity.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
