package com.cheng.unittest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cheng.unittest.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class LoginActivity extends AppCompatActivity {

    private Disposable mDisposable = null;
    private TextView tv_send_identify;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_send_identify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.getIdentify();
            }
        });
    }

    private void getIdentify() {
        tv_send_identify.setEnabled(false);
        // interval隔一秒发一次，到120结束
        mDisposable = Observable
                .interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(120)
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        tv_send_identify.setText(TextUtils.concat(Math.abs(aLong - 120) + "", "秒后重试"));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        tv_send_identify.setText(R.string.login_send_identify);
                        tv_send_identify.setEnabled(true);
                    }


                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

}
