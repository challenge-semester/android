package org.techtown.challengesemestersystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    ArrayList<ChatData> messageItems;
    LayoutInflater layoutInflater;

    public ChatAdapter(ArrayList<ChatData> messageItems,LayoutInflater layoutInflater){
        this.messageItems=messageItems;
        this.layoutInflater=layoutInflater;
    }


    @Override
    public int getCount() {
        return messageItems!=null?0:messageItems.size();
    }

    @Override
    public Object getItem(int i) {
        return messageItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ChatData item=messageItems.get(i);
        View itemView=null;

        TextView tv_nickname;
        TextView tv_message;
        if(item.getNickname().equals("nick1")){
            itemView=layoutInflater.inflate(R.layout.mycontent,viewGroup,false);
            tv_message=itemView.findViewById(R.id.tv_mycontents);
            tv_message.setText(item.getMessage());
        }
        else{
            itemView=layoutInflater.inflate(R.layout.yourcontent,viewGroup,false);
            tv_nickname=itemView.findViewById(R.id.tv_nickname);
            tv_message=itemView.findViewById(R.id.tv_yourcontents);
            tv_nickname.setText(item.getNickname());
            tv_message.setText(item.getMessage());
        }

        return itemView;
    }

    public void addItem(String name,String contents){
        ChatData item=new ChatData();
        item.setNickname(name);
        item.setMessage(contents);
        messageItems.add(item);
    }
}
