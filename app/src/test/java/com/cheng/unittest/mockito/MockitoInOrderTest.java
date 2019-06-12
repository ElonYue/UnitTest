package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Person;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @author : chengyue
 * @date : 2019/6/12 12:21
 */
public class MockitoInOrderTest {

    @Mock
    private Person mPerson;
    @Mock
    private Person mPerson1;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void testPersonInOrder() {

        mPerson.setName("小明");
        mPerson.setSex(1);

        mPerson1.setName("小红");
        mPerson1.setSex(0);

        InOrder mInOrder = Mockito.inOrder(mPerson, mPerson1);
        //执行顺序正确
        mInOrder.verify(mPerson).setName("小明");
        mInOrder.verify(mPerson).setSex(1);

        //执行顺序错误
        // mInOrder.verify(mPerson1).sex = 0
        // mInOrder.verify(mPerson1).name = "小红"

    }
}
