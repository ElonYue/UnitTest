package com.cheng.unittest.powermock;

import com.cheng.unittest.bean.Banana;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * mock静态方法
 *
 * @author : chengyue
 * @date : 2019/6/12 11:21
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Banana.class)
class PowerMockitoStaticMethodTest {

    @Test
    public void testStaticMethod() {
        PowerMockito.mockStatic(Banana.class); //<-- mock静态类
        PowerMockito.when(Banana.color()).thenReturn("绿色");
        Assert.assertEquals("绿色", Banana.color());
    }

    /**
     * 更改类的私有static常量
     */
    @Test
    public void testChangeColor() {
        Whitebox.setInternalState(Banana.class, "COLOR", "红色的");
        Assert.assertEquals("红色的", Banana.color());
    }
}
