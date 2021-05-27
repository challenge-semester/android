package org.techtown.challengesemestersystem;


import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FragmentHome fragmentHome;
    private FragmentAlarm fragmentAlarm;
    private FragmentMessage fragmentMessage;
    private Button btn_home,btn_message,btn_arlam;

    static final String[] ListMenu={"박소영","mini0u0","pthdud1123"};
    ArrayAdapter arrayAdapter;
    ListView listView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentHome=new FragmentHome();
        fragmentAlarm =new FragmentAlarm();
        fragmentMessage=new FragmentMessage();
        btn_home=(Button)findViewById(R.id.button_home);
        btn_arlam=(Button)findViewById(R.id.button_arlam);
        btn_message=(Button)findViewById(R.id.button_message);

        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//이 액티비티에서 툴바를 사용하겠다는 의미
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);//뒤로가기 버튼
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        actionBar.setTitle("알파카");
        //actionBar.setDisplayShowTitleEnabled(false);



        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("홈버튼");
                clickMainButton(0);

            }
        });
        btn_arlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("알람버튼");
                clickMainButton(1);
            }
        });
        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("메세지 버튼");
                clickMainButton(2);

            }
        });


        fragmentTransaction.replace(R.id.fragment_layout,fragmentHome).commitAllowingStateLoss();

    }

    public void clickMainButton(int a){
        fragmentTransaction=fragmentManager.beginTransaction();
        switch (a){
            case 0:
                fragmentTransaction.replace(R.id.fragment_layout,fragmentHome).commitAllowingStateLoss();
                break;
            case 1:
                fragmentTransaction.replace(R.id.fragment_layout, fragmentAlarm).commitAllowingStateLoss();
                break;
            case 2:
                fragmentTransaction.replace(R.id.fragment_layout,fragmentMessage).commitAllowingStateLoss();
                break;

        }
    }

}