package com.cheng.unittest.net;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.net.URLDecoder;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : chengyue
 * @date : 2019/6/6 12:34
 */
public class LoggingInterceptor implements Interceptor {
    private final String TAG = LoggingInterceptor.class.getSimpleName();

//    @Override
//    public Response intercept(Interceptor.Chain chain) throws IOException {
//        Request request = chain.request();
//
//        long t1 = System.nanoTime();
//        Log.d(TAG, String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers
// ()));
//
//        Response response = chain.proceed(request);
//        long t2 = System.nanoTime();
//        Log.d(TAG, String.format("Received response for %s in %.1fms",
//                response.request().url(), (t2 - t1) / 1e6d));
//
//        Log.i(TAG, String.format("%s", "=========== response.headers() ========"));
//        Log.d(TAG, String.format("%s", response.headers()));
//        Log.i(TAG, String.format("%s", "=========== response.body().string() ========"));
//        Log.d(TAG, String.format("%s", response.body().string()));
//        return response;
//    }


    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        MediaType mediaType = null;
        if (response.body() != null) {
            mediaType = response.body().contentType();
        }
        Log.d(TAG, "\n");
        Log.d(TAG, "----------Start----------------");
        Log.d(TAG, "| RequestUrl:" + request.url());
        Log.d(TAG, "| RequestHeaders:\n" + request.headers());

        String method = request.method();
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i) + ":" + (TextUtils.isEmpty(body.encodedValue(i)) ? "参数为空" :
                            URLDecoder.decode(body.encodedValue(i), "utf-8")) + ",");
                }
                if (sb.length() != 0) {
                    sb.delete(sb.length() - 1, sb.length());
                }
                Log.d(TAG, "| RequestParams:\n");
                Log.d(TAG, sb.toString());

            }
        }
        Log.d(TAG, "| ResponseHeaders:\n" + response.headers());
        String content = response.body().string();
        Log.d(TAG, content);

        Log.d(TAG, "----------End:" + duration + "毫秒----------");
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}