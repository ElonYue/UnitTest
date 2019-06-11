package com.cheng.unittest.assertj;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.cheng.unittest.MainActivity;
import com.cheng.unittest.R;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;


/**
 * AssertJ 使用
 *
 * @author : chengyue
 * @date : 2019/6/12 00:37
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {23})
public class AssertJAndroidTest {

    private MainActivity mainActivity;
    private Button mJumpBtn;
    private LinearLayout mRoot;
    private CheckBox checkBox;

    @Before
    public void setUp() {
        //输出日志
        ShadowLog.stream = System.out;
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        mJumpBtn = mainActivity.findViewById(R.id.button1);
        mRoot = mainActivity.findViewById(R.id.root);
        checkBox = mainActivity.findViewById(R.id.checkbox);
    }

    @Test
    public void testView() {
        // Button是否可见
        Assertions.assertThat(mJumpBtn).isVisible();
        // LinearLayout 方向，子View数量
        Assertions.assertThat(mRoot)
                .isVertical()
                .hasChildCount(4);
        // CheckBox是否未选中
        Assertions.assertThat(checkBox).isNotChecked();
    }
}
