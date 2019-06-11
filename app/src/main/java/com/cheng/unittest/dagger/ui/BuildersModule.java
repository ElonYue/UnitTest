package com.cheng.unittest.dagger.ui;

import com.cheng.unittest.dagger.base.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 *
 * @author  : chengyue
 * @date    : 2019/6/12 00:44
 *
 */
@Module
public abstract class BuildersModule {

    @ActivityScope
    @ContributesAndroidInjector
    public abstract LoginDaggerActivity loginDaggerActivityInjector();

}
