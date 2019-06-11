package com.cheng.unittest.dagger.base.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 *
 * @author  : chengyue
 * @date    : 2019/6/12 00:44
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {

}
