package com.cheng.unittest.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static java.sql.DriverManager.println;

/**
 * @author : chengyue
 * @date : 2019/6/12 00:37
 */
public class MyRule implements TestRule {


    @Override
    public Statement apply(final Statement base, final Description description) {

        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                // evaluate前执行方法相当于@Before
                String methodName = description.getMethodName(); // 获取测试方法的名字
                println(methodName + "测试开始！");

                base.evaluate();  // 运行的测试方法

                // evaluate后执行方法相当于@After
                println(methodName + "测试结束！");
            }
        };
    }
}
