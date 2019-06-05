package com.cheng.unittest;

import android.widget.TextView;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author : chengyue
 * @created : at 2018/5/30 11:05
 * @history : change on 2018/5/30 11:05 by chengyue
 * @since : v
 */
public class MockTest {

    @Test
    public void test() {
        TextView mockedTextView = Mockito.mock(TextView.class);
        Mockito.when(mockedTextView.getText()).thenReturn("test");
        System.out.println(mockedTextView.getText());
    }
}
