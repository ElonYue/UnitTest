package com.cheng.unittest.dagger.ui;


import com.cheng.unittest.bean.User;
import com.cheng.unittest.dagger.base.scope.ActivityScope;
import com.cheng.unittest.mvp.base.BaseMVPPresenter;
import com.cheng.unittest.mvp.ui.LoginMvpView;
import com.cheng.unittest.net.GithubApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 *
 * @author  : chengyue
 * @date    : 2019/6/12 00:45
 *
 */
@ActivityScope
public class LoginDaggerPresenter extends BaseMVPPresenter<LoginMvpView> {

    private GithubApi mApi;

    @Inject
    LoginDaggerPresenter(GithubApi githubApi) {
        this.mApi = githubApi;
    }

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    void getIdentify() {
        // interval隔一秒发一次，到120结束
        Disposable mDisposable = Observable
                .interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(120)
                .subscribeWith(new DisposableObserver<Long>() {

                    @Override
                    public void onNext(Long aLong) {
                        mMvpView.countdownNext(Math.abs(aLong - 120) + "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMvpView.showToast("倒计时出现错误！");
                    }

                    @Override
                    public void onComplete() {

                        mMvpView.countdownComplete();
                    }

                });
        mCompositeDisposable.add(mDisposable);
    }

    void login(String mobile, String code) {
        if (mobile.length() != 11) {
            mMvpView.showToast("手机号码不正确");
            return;
        }
        if (code.length() != 6) {
            mMvpView.showToast("验证码不正确");
            return;
        }

        mApi.getUser("chengyue8080")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached()) {
                            mMvpView.showProgress();
                        }
                    }
                })
                .doAfterTerminate(
                        new Action() {
                            @Override
                            public void run() throws Exception {
                                if (isViewAttached()) {
                                    mMvpView.closeProgress();
                                }
                            }
                        }
                )
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(User user) {
                        mMvpView.showToast("登录成功");
                        mMvpView.loginSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMvpView.showToast("登录失败");
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void detachView() {
        super.detachView();
        mCompositeDisposable.clear();
    }

}
