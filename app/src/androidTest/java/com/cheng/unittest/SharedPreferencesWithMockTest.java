package com.cheng.unittest;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

/**
 * @author : chengyue
 * @created : at 2018/5/30 10:19
 * @history : change on 2018/5/30 10:19 by chengyue
 * @since : v
 */
@RunWith(MockitoJUnitRunner.class)
public class SharedPreferencesWithMockTest {

    private static final String KEY_NAME = "login";
    private static final String TEST_EMAIL = "test@email.com";
    private static final Calendar TEST_DATE_OF_BIRTH = Calendar.getInstance();
    @Mock
    SharedPreferences mMockSharedPreferences;
    @Mock
    SharedPreferences.Editor mMockEditor;

    @Before
    public void setUp() throws Exception {
    }

    /**
     * 编写Mock相关代码，代码中mock了SharedPreferences类的getXxx的相关操作，
     * 均返回SharedPreferenceEntry对象的值，同时在代码中使用到了commit和edit，都需要在方法中进行mock实现
     * Creates a mocked SharedPreferences.
     */
    @Test
    private SharedPreferences mockSharePreferences() {
        when(mMockSharedPreferences.getBoolean(eq(KEY_NAME), anyBoolean()))
                .thenReturn(mMockSharedPreferences.getBoolean(KEY_NAME, false));
//        when(mMockEditor.commit()).thenReturn(true);
//        when(mMockSharedPreferences.edit()).thenReturn(mMockEditor);
        return mMockSharedPreferences;
    }

    //return都可以用answer来代替
    @Test
    public final void answerTest() {
        // with thenAnswer():
        ArrayList<String> list = new ArrayList<>();
        when(list.add(anyString())).thenAnswer(returnsFirstArg());
        // with then() alias:
        when(list.add(anyString())).then(returnsFirstArg());
    }
}
