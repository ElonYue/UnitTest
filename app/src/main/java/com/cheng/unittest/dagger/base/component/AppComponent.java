package com.cheng.unittest.dagger.base.component;

import com.cheng.unittest.MyApp;
import com.cheng.unittest.dagger.base.module.AppModule;
import com.cheng.unittest.dagger.base.module.ClientModule;
import com.cheng.unittest.dagger.ui.BuildersModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author : chengyue
 * @date : 2019/6/12 00:43
 */
@Singleton
@Component(modules = {
        AppModule.class,
        ClientModule.class,
        BuildersModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MyApp> {
    }
}
