package com.cheng.unittest.powermock;

import com.cheng.unittest.bean.Person;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

/**
 * mock new方法
 *
 * @author : chengyue
 * @date : 2019/6/12 11:05
 */
public class PowerMockitoNewClassTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    @PrepareForTest(Person.class)
    public void testNewClass() throws Exception {
        Person mPerson = PowerMockito.mock(Person.class);
        PowerMockito.when(mPerson.getName()).thenReturn("大香蕉");
        //如果new新对象，则返回这个上面设置的这个对象
        PowerMockito.whenNew(Person.class).withNoArguments().thenReturn(mPerson);
        //new新的对象
        Person newPerson = new Person();
        Assert.assertEquals("大香蕉", newPerson.getName());
    }
}
