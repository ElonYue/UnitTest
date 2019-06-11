package com.cheng.unittest.robolectric.shadow;

import com.cheng.unittest.bean.Person;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * 自定义Shadow
 * [Person] 的影子类
 *
 * @author : chengyue
 * @date : 2019/6/12 00:39
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
