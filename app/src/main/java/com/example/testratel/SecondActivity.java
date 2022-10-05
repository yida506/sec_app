package com.example.testratel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle data = getIntent().getBundleExtra("data");
        int id = data.getInt("age");
        String name = data.getString("name");


        Button btnThree = (Button) findViewById(R.id.button3);
        // 弹窗
        btnThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                BuildDialog(v);
                Log.i("intent", name.toString());
//                btnThree.setText(name.toString());
            }
        });



    }

    public void BuildDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("this is Dialog");
        builder.setMessage("this is message");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SecondActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();//销毁对话框
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
                dialog.dismiss();//销毁对话框
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}