package com.cheng.unittest.dagger.base.module;

import android.content.Context;

import com.cheng.unittest.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 * @author  : chengyue
 * @date    : 2019/6/12 00:43
 *
 */


@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(MyApp mApplication) {
        return mApplication.getApplicationContext();
    }
}
