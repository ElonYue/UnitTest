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
 * 作者：weilu on 2017/4/26 15:20
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ClientModule.class,
        BuildersModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MyApp> {}
}
