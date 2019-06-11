package com.cheng.unittest.mvp.base;

/**
 * @author : chengyue
 * @date : 2019/6/10 16:21
 */
public interface MvpView {

    /***
     * 显示Progress
     */
    void showProgress();

    /***
     * 关闭Progress
     */
    void closeProgress();

    /***
     * @param text 消息内容
     */
    void showToast(String text);
}
