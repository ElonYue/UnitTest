package com.cheng.unittest.dagger.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cheng.unittest.R;
import com.cheng.unittest.dagger.base.BaseMVPDaggerActivity;
import com.cheng.unittest.mvp.ui.LoginMvpView;

import dagger.android.AndroidInjection;

public class LoginDaggerActivity extends BaseMVPDaggerActivity<LoginMvpView, LoginDaggerPresenter> implements LoginMvpView, View.OnClickListener {


    private TextView tv_login;
    private TextView tv_send_identify;
    private EditText et_mobile;
    private EditText et_identify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_login = findViewById(R.id.tv_login);
        tv_send_identify = findViewById(R.id.tv_send_identify);
        et_mobile = findViewById(R.id.et_mobile);
        et_identify = findViewById(R.id.et_identify);

        tv_login.setOnClickListener(this);
        tv_send_identify.setOnClickListener(this);
    }

    @Override
    public void countdownComplete() {
        tv_send_identify.setText(R.string.login_send_identify);
        tv_send_identify.setEnabled(true);
    }

    @Override
    public void countdownNext(String time) {
        tv_send_identify.setText(TextUtils.concat(time, "秒后重试"));
    }

    @Override
    public void loginSuccess() {
        showToast("登录成功");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_send_identify: {
                tv_send_identify.setEnabled(false);
                mPresenter.getIdentify();
            }
            break;
            case R.id.tv_login:
                mPresenter.login(et_mobile.getText().toString().trim(), et_identify.getText().toString().trim());
                break;
            default:
                break;

        }
    }


}
