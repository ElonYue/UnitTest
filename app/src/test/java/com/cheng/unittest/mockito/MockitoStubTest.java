package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Person;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

/**
 * @Description: 常用打桩方法示例
 * @Author: weilu
 * @Time: 2017/11/4 11:11.
 */

class MockitoStubTest {

    @Mock
    Person mPerson;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testPersonReturn() {
        Mockito.when(mPerson.getName()).thenReturn("小明");
        Mockito.when(mPerson.getSex()).thenThrow(new NullPointerException("滑稽：性别不明"));

        // 输出"小明"
        System.out.println(mPerson.getName());

        Mockito.doReturn("小小").when(mPerson).getName();
        // 输出"小小"
        System.out.println(mPerson.getName());

        // 抛出异常
//          System.out.println(mPerson.sex)

    }

    @Test
    public void testPersonRealMethod() {
        Mockito.doCallRealMethod().when(mPerson).getAge();
        //调用Person的真实getAge()方法
        System.out.println(mPerson.getAge());
    }

    @Test
    public void testPersonNothing() {
        Mockito.doNothing().doThrow(new RuntimeException()).when(mPerson).setSex(1);
        //第一次什么都不做
        mPerson.setSex(1);
        //异常抛出在下面这行
        //mPerson.sex = 1
    }

    @Test
    public void testPersonAnswer() {
        Mockito.when(mPerson.eat(ArgumentMatchers.anyString())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return args[0].toString() + "真好吃";
            }
        });
        //输出：饺子真好吃
        System.out.println(mPerson.eat("饺子"));
    }
}
