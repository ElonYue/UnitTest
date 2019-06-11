package com.cheng.unittest.dagger.base.module;

import android.content.Context;

import com.cheng.unittest.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author weilu
 * 作者：weilu on 2018/2/5 15:20
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(MyApp mApplication) {
        return mApplication.getApplicationContext();
    }
}
