package org.techtown.challengesemestersystem;

public class UserInfo {
    static String username;
    public String lastContent;

    public UserInfo(String username,String lastContent){
        this.username=username;
        this.lastContent=lastContent;
    }

    static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastcontent() {
        return lastContent;
    }

    public void setLastcontent(String lastContent) {
        this.lastContent = lastContent;
    }




    

}
