package org.techtown.challengesemestersystem;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ChatfriendAdapter extends BaseAdapter {
    ArrayList<UserInfo> friendItems;
    LayoutInflater layoutInflater;
    public ChatfriendAdapter(ArrayList<UserInfo> friendItems,LayoutInflater layoutInflater){
        this.friendItems=friendItems;
        this.layoutInflater=layoutInflater;
    }

    @Override
    public int getCount() {
        return friendItems!=null? friendItems.size():0;
    }

    @Override
    public Object getItem(int i) {
        return friendItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        UserInfo friend=friendItems.get(i);
        View itemView;

        itemView=layoutInflater.inflate(R.layout.adapter_frienditem,viewGroup,false);
        TextView name=(TextView)itemView.findViewById(R.id.tv_nickname);
        TextView message=(TextView)itemView.findViewById(R.id.tv_message);
        name.setText(friend.getUsername());
        message.setText(friend.getLastcontent());

        /*
        LinearLayout cmdArea=(LinearLayout)itemView.findViewById(R.id.LL_frienditem);
        cmdArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(view.getContext(),friendItems.get(i).getLastcontent(),Toast.LENGTH_SHORT).show();
            }
        });


         */
        return itemView;
    }
    public void addItem(String name,String content){
        UserInfo data=new UserInfo(name,content);
        data.setUsername(name);
        data.setLastcontent(content);

        friendItems.add(data);
    }
}
