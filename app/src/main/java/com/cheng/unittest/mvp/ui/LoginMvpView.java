package com.cheng.unittest.mvp.ui;

import com.cheng.unittest.mvp.base.MvpView;

/**
 * @author : chengyue
 * @date : 2019/6/10 16:21
 */
public interface LoginMvpView extends MvpView {

    /**
     * 倒计时完成
     */
    void countdownComplete();

    /**
     * 倒计时中
     *
     * @param time 剩余时间
     */
    void countdownNext(String time);

    /**
     * 登录成功
     */
    void loginSuccess();

}
