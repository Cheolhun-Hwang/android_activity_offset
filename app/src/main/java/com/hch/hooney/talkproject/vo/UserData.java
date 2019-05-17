package com.hch.hooney.talkproject.vo;

public class UserData {
    private String uid;
    private String nickname;
    private String create;

    public UserData() {
        this.uid = "None";
        this.nickname = "None";
        this.create = "None";
    }

    public UserData(String uid, String nickname, String create) {
        this.uid = uid;
        this.nickname = nickname;
        this.create = create;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }
}
