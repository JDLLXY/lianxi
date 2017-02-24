package com.example.jdl.jdlapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        TextView tv = (TextView) findViewById(R.id.tv2);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("SecondActivity","SecondActivityClose");
                setResult(RESULT_OK,intent);//必须传递两个参数，第二个参数不能少否则在接受数据那边的activity会空指针
                finish();
            }
        });
    }
}
