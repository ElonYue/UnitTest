package com.cheng.unittest.net;

import android.util.Log;

import com.cheng.unittest.bean.User;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import java.net.URISyntaxException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {23})
public class MockGithubServiceTest {
    private static String JSON_ROOT_PATH = "/json/";
    private String jsonFullPath;
    private GithubApi mockGithubService;

    @Rule
    public RxJavaRule rule = new RxJavaRule();

    @Before
    public void setUp() throws URISyntaxException {
        ShadowLog.stream = System.out;
        //获取测试json文件地址
        jsonFullPath = MockGithubServiceTest.class.getResource(JSON_ROOT_PATH).toURI().getPath();
        assertNotNull(jsonFullPath);

        //定义Http Client,并添加拦截器
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new MockInterceptor(jsonFullPath))
                .build();

        //设置Http Client
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubApi.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mockGithubService = retrofit.create(GithubApi.class);
    }

    @Test
    public void getUserTest() {
        mockGithubService.getUser("chengyue8080")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        assertEquals("chengyue8080", user.name);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Test", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }

                });
    }


}
