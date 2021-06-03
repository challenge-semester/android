package org.techtown.challengesemestersystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BoardCreateActivity extends AppCompatActivity {

    private Button btn_cancel, btn_upload;
    private EditText edit_content;
    private String studentNumber, content;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_create);



        btn_cancel=(Button)findViewById(R.id.btn_cancel);
        btn_upload=(Button)findViewById(R.id.btn_upload);
        edit_content=(EditText)findViewById(R.id.edit_content);

        content=edit_content.getText().toString();
        studentNumber=UserInfo.getUsername();


        btn_cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendArray();
            }
        });
    }

    private void sendArray(){
        JSONObject wrapObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",content);
            jsonObject.put("studentNumber",studentNumber);
            jsonArray.put(jsonObject);
            Log.d("json","json2");
            Log.e("json","생성한 json: "+jsonObject.toString());
        }catch(JSONException e){
            e.printStackTrace();
        }
    }


}