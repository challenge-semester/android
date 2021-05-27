package org.techtown.challengesemestersystem;

import android.content.Intent;
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

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private EditText edt_name, edt_id, edt_pw, edt_pw2, edt_email, edt_phone;
    private RadioButton radio_woman, radio_man, radio_s, radio_b, radio_g;
    private RadioGroup radioGroup_sex, radioGroup_campus;
    private Spinner spinner_coll, spinner_dep; //단과대, 학부(과)
    private ArrayAdapter spinnerAdapter_col,spinnerAdapter_dep;
    private String department, email, name, password, phoneNumber, studentNumber;
    final ArrayList<String> list_coll=new ArrayList<>();
    final ArrayList<String> list_dep=new ArrayList<>();
    Button btn_register;
    int selected=100; //대학 스피너 선택된 position

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

        spinnerAdapter_col=new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list_coll);
        spinner_coll.setAdapter(spinnerAdapter_col);

        spinner_coll.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RegisterActivity.this,"학과를 선택해주세요.",Toast.LENGTH_SHORT).show();
                selected=position;
                setDepSpinner();//학과선택 스피너
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    RadioButton.OnClickListener radioButtonClickListener=new RadioButton.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i == R.id.radio_woman){

            }
            else if(i == R.id.radio_man){

            }
            if(i == R.id.radio_campus_b){

            }
            else if(i==R.id.radio_campus_g){

            }
            else if(i==R.id.radio_campus_s){

            }
        }
    };

    private void bindView(){
        btn_register=(Button)findViewById(R.id.btn_register);
        edt_name=(EditText)findViewById(R.id.edt_name);
        edt_id=(EditText)findViewById(R.id.edt_id);
        edt_pw=(EditText)findViewById(R.id.edt_pw);
        edt_pw2=(EditText)findViewById(R.id.edt_pw2);
        edt_email=(EditText)findViewById(R.id.edt_email);
        edt_phone=(EditText)findViewById(R.id.edt_phone);

        radioGroup_sex=(RadioGroup)findViewById(R.id.radioGroup_sex);
        radio_woman=(RadioButton)findViewById(R.id.radio_woman);
        radio_man=(RadioButton)findViewById(R.id.radio_man);
        radio_woman.setOnClickListener(radioButtonClickListener);
        radioGroup_sex.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        radioGroup_campus=(RadioGroup)findViewById(R.id.radioGroup_campus);
        radio_s=(RadioButton)findViewById(R.id.radio_campus_s); //승학캠퍼스
        radio_b=(RadioButton)findViewById(R.id.radio_campus_b); //부민
        radio_g=(RadioButton)findViewById(R.id.radio_campus_g); //구덕
        radioGroup_campus.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        spinner_coll=(Spinner)findViewById(R.id.spinner_college);
        spinner_dep=(Spinner)findViewById(R.id.spinner_department);
    }

    private void setDepSpinner(){
        list_dep.clear();
        Log.d("clear","됐다");

        if(selected==0){ //인문대학
            list_dep.add("철학과");    list_dep.add("윤리문화학과");     list_dep.add("사학과");
            list_dep.add("고고미술학과"); list_dep.add("국어국문학과"); list_dep.add("영어영문학과");
            list_dep.add("한국어문학과"); list_dep.add("교육학과");
        }
        else if(selected==1){ //자연과학대학
            list_dep.add("정보수학과");  list_dep.add("수학과");    list_dep.add("반도체학과");
            list_dep.add("신소재물리학과");    list_dep.add("화학과");    list_dep.add("생명과학과");
            list_dep.add("식품영양학과"); list_dep.add("바이오메디컬학과");
        }
        else if(selected==2){ //생명과학대학
            list_dep.add("분자유전공학과");    list_dep.add("유전공학과");  list_dep.add("분자생명공학과");
            list_dep.add("응용생물공학과");    list_dep.add("생명공학과");  list_dep.add("의약생명공학과");
            list_dep.add("식품생명공학과");    list_dep.add("생명자원산업학과");
        }
        else if(selected==3){ //공과대학
            list_dep.add("컴퓨터공학과"); list_dep.add("AI공학부");  list_dep.add("산업경영공학과");
            list_dep.add("전기공학과");  list_dep.add("전자공학과");  list_dep.add("화학공학과");
            list_dep.add("유기재료고분자공학과"); list_dep.add("건축공학과");
        }
        else if(selected==4){ //경영대학
            list_dep.add("경영학과");   list_dep.add("관광경영학과"); list_dep.add("국제관광학과");
            list_dep.add("국제무역학과"); list_dep.add("경영정보학과"); list_dep.add("금융학과");
            list_dep.add("지식서비스경영학학과"); list_dep.add("융합경영학과");
        }
        System.out.println(list_dep);

        spinnerAdapter_dep=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,list_dep);
        spinner_dep.setAdapter(spinnerAdapter_dep);
        System.out.println("학과서낵000");

        spinner_dep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("학과선택");
                department=spinner_dep.getSelectedItem().toString();
                System.out.println(department);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}