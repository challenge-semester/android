package org.techtown.challengesemestersystem;

public class ChatData {
    String nickname;
    String message;

    public ChatData(){}
    public ChatData(String nickname,String message){
        this.nickname=nickname;
        this.message=message;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
