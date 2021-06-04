package org.techtown.challengesemestersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class test extends AppCompatActivity {
    String url = "http://118.67.131.121:8080/api/members/join";
    RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        EditText id=(EditText)findViewById(R.id.id);
        EditText pw=(EditText)findViewById(R.id.pw);
        Button button=(Button)findViewById(R.id.button);

        String idvalue=id.getText().toString();
        String pwvalue=pw.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request=new StringRequest(
                        Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                System.out.println(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                    }
                }
                );
                queue.add(request);
            }

        });

    }
}