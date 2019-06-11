package com.cheng.unittest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.cheng.unittest.mvp.ui.LoginMVPActivity;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : chengyue
 * @date : 2019/6/10 16:21
 */
public class MainActivity extends AppCompatActivity {

    private final String type = "TYPE";

    public String lifecycleState = null;

    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lifecycleState = "onCreate";
        checkbox = findViewById(R.id.checkbox);
    }

    public void jump(View view) {

//        startActivity(Intent(this, LoginActivity::class.java))

        startActivity(new Intent(this, LoginMVPActivity.class));

//          startActivity(Intent(this, LoginDaggerActivity::class.java))
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello UT!", Toast.LENGTH_LONG).show();
    }

    public void showDialog(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Hello UT！")
                .setTitle("提示")
                .create();
        alertDialog.show();
    }

    public void inverse(View view) {
        checkbox.setChecked(!checkbox.isChecked());
    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycleState = "onStart";
    }

    @Override
    public void onResume() {
        super.onResume();
        lifecycleState = "onResume";
    }


    @Override
    public void onPause() {
        super.onPause();
        lifecycleState = "onPause";
    }


    @Override
    public void onStop() {
        super.onStop();
        lifecycleState = "onStop";
    }


    @Override
    public void onRestart() {
        super.onRestart();
        lifecycleState = "onRestart";
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycleState = "onDestroy";
    }

    public void getUserTest() {
        String url = "https://api.github.com/users/chengyue8080";
        get(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("TEST", "onSubscribe");
                    }

                    @Override
                    public void onNext(String result) {
                        Log.d("TEST", "onNext");
                        System.out.println(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TEST", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TEST", "onComplete");
                    }
                });

    }

    public Observable<String> get(final String url) {
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> emitter) {
                new OkHttpClient().newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("TEST", "call onFailure");
                        emitter.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("TEST", "call onResponse");
                        String body = response.body().string();
                        emitter.onNext(body);
                        emitter.onComplete();
                    }
                });
            }
        });
    }
}
