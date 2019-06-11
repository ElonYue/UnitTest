package com.cheng.unittest;

import com.cheng.unittest.dagger.base.component.DaggerAppComponent;
import com.cheng.unittest.net.GithubApi;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 *
 * @author  : chengyue
 * @date    : 2019/6/12 00:46
 */

public class MyApp extends DaggerApplication {

    static MyApp instance;

    @Inject
    GithubApi githubApi;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    @Override
    public AndroidInjector<MyApp> applicationInjector() {
//        return null;
        return DaggerAppComponent.builder().create(this);
    }
}
