package com.cheng.unittest.net;

import com.cheng.unittest.bean.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author : chengyue
 * @date : 2019/6/10 16:21
 */
public interface GithubApi {

    @GET("users/{username}")
    public Observable<User> getUser(@Path("username") String username);


    public String BASE_URL = "https://api.github.com/";
}
