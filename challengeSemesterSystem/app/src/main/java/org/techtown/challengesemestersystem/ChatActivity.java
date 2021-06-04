package org.techtown.challengesemestersystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    EditText edtmessage;
    Button button;
    ListView listView;
    ArrayList<ChatData> messageItem=new ArrayList<>();
    ChatAdapter chatadater;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        System.out.println("여기는 실행되니?");

        TextView test=(TextView)findViewById(R.id.tv_test);
        edtmessage=(EditText)findViewById(R.id.edt_context);
        listView=(ListView)findViewById(R.id.LL_Chat);
        button=(Button)findViewById(R.id.btn_send);
        chatadater=new ChatAdapter(messageItem,getLayoutInflater());
        listView.setAdapter(chatadater);

        Intent intent=getIntent();
        String text=intent.getExtras().getString("key").toString();
        test.setText(text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatData item=new ChatData();
                item.setNickname("nick1");
                item.setMessage(edtmessage.getText().toString());
                edtmessage.setText(" ");
                messageItem.add(item);
                chatadater.notifyDataSetChanged();
                listView.setSelection(messageItem.size() - 1);//리스트뷰의 마지막 위치로 스크롤 이동
            }
        });

    }
}
