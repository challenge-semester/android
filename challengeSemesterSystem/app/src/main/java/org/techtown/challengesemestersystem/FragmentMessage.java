package org.techtown.challengesemestersystem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentMessage extends Fragment {
    ListView listView;
    ArrayList<UserInfo> friendItems=new ArrayList<>();
    ChatfriendAdapter adaterfriend;
    public FragmentMessage(){}

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity mainActivity=(MainActivity)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.activity_fragment_message,container,false);

        listView=(ListView)rootView.findViewById(R.id.Lv_chatfriend);
        adaterfriend=new ChatfriendAdapter(friendItems,getLayoutInflater());
        listView.setAdapter(adaterfriend);

        for(int i =0;i<10;i++){
            adaterfriend.addItem("사람"+(int)i,"박우빈 옆에서 지금 채팅구현중이래요 바보멍충이 똥개 해삼 말미잘 이렇게 길게 적으면 어떻게 나올려나 궁금해서 길게 적는 중입니다 박소영 이쁘다");
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(getContext(), ChatActivity.class);
                intent.putExtra("key",friendItems.get(i).getUsername().toString());
                System.out.println("화면은 이동할거 같아");
                startActivity(intent);

            }
        });


        return rootView;


    }


}
