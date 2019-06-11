package com.cheng.unittest.robolectric.shadow;

import com.cheng.unittest.bean.Person;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * [Person] 的影子类
 *
 * @Description: 自定义Shadow
 * @Author: weilu
 * @Time: 2017/12/4 13:05.
 */
@Implements(Person.class)
public class ShadowPerson {

    String name;
    int sex;
    int age;

    @Implementation
    public String getName() {
        return "AndroidUT";
    }

    @Implementation
    public int getSex() {
        return 0;
    }

    @Implementation
    public int getAge() {
        return 18;
    }



}
