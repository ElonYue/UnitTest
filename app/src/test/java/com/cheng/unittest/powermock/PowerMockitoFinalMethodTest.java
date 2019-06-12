package com.cheng.unittest.powermock;

import com.cheng.unittest.bean.Banana;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * mock final方法
 *
 * @author : chengyue
 * @date : 2019/6/12 11:04
 */
@RunWith(PowerMockRunner.class)
class PowerMockitoFinalMethodTest {
    @Test
    @PrepareForTest(Banana.class)
    public void testFinalMethod() {
        Banana mBanana = PowerMockito.mock(Banana.class);
        PowerMockito.when(mBanana.isLike()).thenReturn(false);
        Assert.assertFalse(mBanana.isLike());
    }
}
