package com.cheng.unittest.dagger.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.cheng.unittest.mvp.base.BaseMVPPresenter;
import com.cheng.unittest.mvp.base.MvpView;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * @author weilu
 * Created by weilu on 2018/2/5.
 */
public abstract class BaseMVPDaggerActivity<V extends MvpView, T extends BaseMVPPresenter<V>> extends DaggerAppCompatActivity implements MvpView {

    @Inject
    public T mPresenter;
    ProgressDialog mProgress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView((V) this);
        mProgress = new ProgressDialog(this);
        mProgress.setMessage("加载中...");
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        if (mProgress != null && !mProgress.isShowing()) {
            mProgress.show();
        }
    }

    @Override
    public void closeProgress() {
        if (mProgress != null && mProgress.isShowing()) {
            mProgress.dismiss();
        }
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
