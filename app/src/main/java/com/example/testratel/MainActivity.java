package com.example.testratel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOne = (Button) findViewById(R.id.button1);
        Button btnTwo = (Button) findViewById(R.id.button2);

        TextView textView = (TextView)findViewById(R.id.textview);
        textView.setText(Encrypt("test"));

        final int[] settimes = {0};
        // 点击次数显示
        btnOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i(TAG, "click button");
//                Person lan1 = new Person("lan", settimes[0]);
                Person lan2 = new Person("lan", settimes[0], 1);

//                HttpTest();
                // 这里可以hook textview, button
                btnOne.setText("change button" + lan2.getName() + lan2.getAge() + "lan2" + lan2.other);
                settimes[0] += 1;


//                HttpTest();
            }
        });
        // 跳转页面
        btnTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // 创建一个Bundle对象封装数据
                Bundle data = new Bundle();
                data.putInt("age",18);
                data.putString("name", "Jack");
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
    }


    public void HttpTest() {
        String url = "https://reqres.in/api/isers?page=2";
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();
                    Log.i("success", response.body().string());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static String Encrypt(String str1){
        String str2 = str1 + " end";
        return str2;
    }
}