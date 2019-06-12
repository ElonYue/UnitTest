package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Person;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @Description: 常用参数匹配器示例
 * @Author: weilu
 * @Time: 2017/11/4 18:32.
 */

public class MockitoMatchersTest {

    //使用@Mock注解
    @Mock
    private Person mPerson;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testPersonAny() {
        Mockito.when(mPerson.eat(ArgumentMatchers.any(String.class))).thenReturn("米饭");
        //或
//        `when`(mPerson.eat(anyString())).thenReturn("米饭")

        //输出米饭
        System.out.println(mPerson.eat("面条"));

    }

    @Test
    public void testPersonContains() {

        Mockito.when(mPerson.eat(ArgumentMatchers.contains("面"))).thenReturn("面条");
        //输出面条
        System.out.println(mPerson.eat("面"));

    }

    @Test
    public void testPersonArgThat() {

        //自定义输入字符长度为偶数时，输出面条。
        Mockito.when(mPerson.eat(ArgumentMatchers.argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String argument) {
                return argument.length() % 2 == 0;
            }
        }))).thenReturn("面条");
        //输出面条
        System.out.println(mPerson.eat("1234"));

    }

}
