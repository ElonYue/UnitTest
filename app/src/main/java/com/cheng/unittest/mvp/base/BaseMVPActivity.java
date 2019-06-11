package com.cheng.unittest.mvp.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author : chengyue
 * @date : 2019/6/10 16:21
 */
public abstract class BaseMVPActivity<V extends MvpView, T extends BaseMVPPresenter<V>> extends AppCompatActivity implements MvpView {

    /**
     * Presenter对象
     */
    public T mPresenter = null;
    public ProgressDialog mProgress = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        mProgress = new ProgressDialog(this);
        mProgress.setMessage("加载中...");
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
    }

    /**
     * 创建Presenter对象
     *
     * @return Presenter对象
     */
    protected abstract T createPresenter();

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
