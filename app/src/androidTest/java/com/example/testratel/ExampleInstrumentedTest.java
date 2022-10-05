package com.example.testratel;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.testratel", appContext.getPackageName());
    }

    @Test
    public void testapi (){
        String url = "https://reqres.in/api/isers?page=2";


        //第一步 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient.Builder().build();
        //第二步 创建Request对象
        Request request = new Request.Builder().url(url).build();
        //第三步 创建Call对象（Call其实是一个接口，具体实现还是RealCall类中）
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //异步请求失败之后的回调
                Log.i("error", "failed");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("success", "进入api");
                //异步请求成功之后的回调
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("success", response.body().toString());
                        }
                    });
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        Log.i("end", "api end");
    }
}