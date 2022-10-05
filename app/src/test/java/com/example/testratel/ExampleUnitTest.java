package com.example.testratel;

import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testapi (){
        //第一步 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient.Builder().build();
        //第二步 创建Request对象
        Request request = new Request.Builder().url("https://www.baidu.com").build();
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
                //异步请求成功之后的回调
                Log.i("success", response.body().string());
            }
        });
        Log.i("end", "api end");
    }
}