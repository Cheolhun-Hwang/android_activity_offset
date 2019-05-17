package com.hch.hooney.talkproject.vo;

public class ListData {
    private String rid;
    private String name;
    private String create;
    private String pwd;
    private boolean secret;

    public ListData() {
        this.rid = "None";
        this.name = "None";
        this.create = "None";
        this.pwd = "None";
        this.secret = false;
    }

    public ListData(String rid, String name, String create, String pwd, boolean sec) {
        this.rid = rid;
        this.name = name;
        this.create = create;
        this.pwd = pwd;
        this.secret = sec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }
}
