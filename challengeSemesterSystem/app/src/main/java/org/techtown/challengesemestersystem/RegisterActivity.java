package org.techtown.challengesemestersystem;

import android.app.DownloadManager;
import android.content.Intent;
import android.icu.util.Output;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText edt_name, edt_id, edt_pw, edt_pw2, edt_email, edt_phone;
    private RadioButton radio_woman, radio_man, radio_s, radio_b, radio_g;
    private RadioGroup radioGroup_sex, radioGroup_campus;
    private Spinner spinner_coll, spinner_dep; //단과대, 학부(과)
    private ArrayAdapter spinnerAdapter_col, spinnerAdapter_dep;
    private String department, email, username, password, password2, phoneNumber, studentNumber;
    final ArrayList<String> list_coll = new ArrayList<>();
    final ArrayList<String> list_dep = new ArrayList<>();
    private Button btn_register;
    int selected = 100; //대학 스피너 선택된 position

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        bindView();

        //단과대학 스피너
        list_coll.add("인문과학대학");
        list_coll.add("자연과학대학");
        list_coll.add("생명과학대학");
        list_coll.add("공과대학");
        list_coll.add("경영대학");

        spinnerAdapter_col = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list_coll);
        spinner_coll.setAdapter(spinnerAdapter_col);

        spinner_coll.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RegisterActivity.this, "학과를 선택해주세요.", Toast.LENGTH_SHORT).show();
                selected = position;
                setDepSpinner();//학과선택 스피너
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                email = edt_email.getText().toString();
                password = edt_pw.getText().toString();
                password2 = edt_pw2.getText().toString();
                phoneNumber = edt_phone.getText().toString();
                studentNumber = edt_id.getText().toString();
                username = edt_name.getText().toString();
/*
                String data="{"+
                        "\"deparment:\""+department+"\","+
                        "\"email:\""+email+"\","+
                        "\"password:\""+password+"\","+
                        "\"phoneNumber:\""+phoneNumber+"\","+
                        "\"studentNumber:\""+studentNumber+"\","+
                        "\"username:\""+username+"\","+
                        "}";
                */
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("department",department);
                    jsonObject.put("email",email);
                    jsonObject.put("password",password);
                    jsonObject.put("phoneNumber",phoneNumber);
                    jsonObject.put("studentNumber",studentNumber);
                    jsonObject.put("username",username);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    sendRequest(jsonObject);
                    System.out.println("서버에 요청 보냈다~");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                System.out.println(jsonObject);

                Log.d("json", "비번1:" + password + " 비번2:" + password2);
                //비밀번호 2개가 다를 때
                if (password.equals(password2)) {
                    //sendArray();
                } else { //일치할 때
                    Log.d("json", "비번1:" + password + " 비번2:" + password2);
                    Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    edt_pw.setSelection(edt_pw.length());
                }
                startActivity(intent);
            }
        });

    }

    public void sendRequest(JSONObject data) throws JSONException {
        String url = "http://118.67.131.121:8080/api/members/join";
        //String url = "https://webhook.site/7705efe4-8ce5-4503-90be-32e2e130bb67";
        Log.d("sy","개빡치낟ㄷㄷㄷㄷㄷㄷㄷㄷㄷㄷ");
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue =Volley.newRequestQueue(getApplicationContext());
        queue.add(jsonObjectRequest);







    }








    RadioButton.OnClickListener radioButtonClickListener = new RadioButton.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if (i == R.id.radio_woman) {

            } else if (i == R.id.radio_man) {

            }
            if (i == R.id.radio_campus_b) {

            } else if (i == R.id.radio_campus_g) {

            } else if (i == R.id.radio_campus_s) {

            }
        }
    };

    private void bindView() {
        btn_register = (Button) findViewById(R.id.btn_register);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_pw = (EditText) findViewById(R.id.edt_pw);
        edt_pw2 = (EditText) findViewById(R.id.edt_pw2);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_phone = (EditText) findViewById(R.id.edt_phone);

        radioGroup_sex = (RadioGroup) findViewById(R.id.radioGroup_sex);
        radio_woman = (RadioButton) findViewById(R.id.radio_woman);
        radio_man = (RadioButton) findViewById(R.id.radio_man);
        radio_woman.setOnClickListener(radioButtonClickListener);
        radioGroup_sex.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        radioGroup_campus = (RadioGroup) findViewById(R.id.radioGroup_campus);
        radio_s = (RadioButton) findViewById(R.id.radio_campus_s); //승학캠퍼스
        radio_b = (RadioButton) findViewById(R.id.radio_campus_b); //부민
        radio_g = (RadioButton) findViewById(R.id.radio_campus_g); //구덕
        radioGroup_campus.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        spinner_coll = (Spinner) findViewById(R.id.spinner_college);
        spinner_dep = (Spinner) findViewById(R.id.spinner_department);
    }

    private void setDepSpinner() {
        list_dep.clear();
        Log.d("clear", "됐다");

        if (selected == 0) { //인문대학
            list_dep.add("철학과");
            list_dep.add("윤리문화학과");
            list_dep.add("사학과");
            list_dep.add("고고미술학과");
            list_dep.add("국어국문학과");
            list_dep.add("영어영문학과");
            list_dep.add("한국어문학과");
            list_dep.add("교육학과");
        } else if (selected == 1) { //자연과학대학
            list_dep.add("정보수학과");
            list_dep.add("수학과");
            list_dep.add("반도체학과");
            list_dep.add("신소재물리학과");
            list_dep.add("화학과");
            list_dep.add("생명과학과");
            list_dep.add("식품영양학과");
            list_dep.add("바이오메디컬학과");
        } else if (selected == 2) { //생명과학대학
            list_dep.add("분자유전공학과");
            list_dep.add("유전공학과");
            list_dep.add("분자생명공학과");
            list_dep.add("응용생물공학과");
            list_dep.add("생명공학과");
            list_dep.add("의약생명공학과");
            list_dep.add("식품생명공학과");
            list_dep.add("생명자원산업학과");
        } else if (selected == 3) { //공과대학
            list_dep.add("컴퓨터공학과");
            list_dep.add("AI공학부");
            list_dep.add("산업경영공학과");
            list_dep.add("전기공학과");
            list_dep.add("전자공학과");
            list_dep.add("화학공학과");
            list_dep.add("유기재료고분자공학과");
            list_dep.add("건축공학과");
        } else if (selected == 4) { //경영대학
            list_dep.add("경영학과");
            list_dep.add("관광경영학과");
            list_dep.add("국제관광학과");
            list_dep.add("국제무역학과");
            list_dep.add("경영정보학과");
            list_dep.add("금융학과");
            list_dep.add("지식서비스경영학학과");
            list_dep.add("융합경영학과");
        }
        System.out.println(list_dep);

        spinnerAdapter_dep = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list_dep);
        spinner_dep.setAdapter(spinnerAdapter_dep);
        System.out.println("학과서낵000");

        spinner_dep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("학과선택");
                department = spinner_dep.getSelectedItem().toString();
                System.out.println(department);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /*
    private void sendArray() {
        JSONObject jsonObject = new JSONObject();
        //JSONObject head=new JSONObject();
        //JSONArray jsonArray = new JSONArray();
        try {
            jsonObject.put("department", department);
            jsonObject.put("email", email);
            jsonObject.put("passwrod", password);
            jsonObject.put("phoneNumber", phoneNumber);
            jsonObject.put("studentNumber", studentNumber);
            jsonObject.put("username", username);
            //jsonArray.put(jsonObject);
            Log.e("json", "생성한 json: " + jsonObject.toString());
            System.out.println("json toString: "+jsonObject.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        String urlStr = "https://webhook.site/6810ba2b-8313-4549-83ef-11c6ba02fa51";
        HttpURLConnection conn=null;
        JSONObject responseJson=null;

        try {
            URL url = new URL(urlStr);
            conn=(HttpURLConnection)url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestProperty("Accept","application/json");

            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.connect();

            OutputStream os=conn.getOutputStream();

            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write(jsonObject.toString());
            bw.flush();
            bw.close();

            int responseCode=conn.getResponseCode();
            if(responseCode==400)
                System.out.println("400:: 해당 명령 실행 불가");
            else if(responseCode==401)
                System.out.println("401:: Header 오류");
            else if(responseCode==500)
                System.out.println("500:: 서버 에러");
            else{
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb=new StringBuilder();
                String line="";
                while((line=br.readLine())!=null)
                    sb.append(line);
                responseJson=new JSONObject(sb.toString());
            }

        } catch(IOException ie){
            System.out.println("IOException "+ie.getCause());
            ie.printStackTrace();
        } catch(Exception e){
            System.out.println("Exception "+e.getCause());
            e.printStackTrace();
        }



    }

     */
}