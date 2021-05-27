package org.techtown.challengesemestersystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        System.out.println("여기는 실행되니?");
        //TextView test=(TextView)findViewById(R.id.tv_test);

        Intent intent=getIntent();
        String text=intent.getExtras().getString("key").toString();
        //test.setText(text);

    }
}
