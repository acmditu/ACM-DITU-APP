package com.afd.dituacm;

public class AllMembers {

    String uid;
    String name;
    String email;
    String Mobile;

    public AllMembers() {

    }

    public AllMembers(String uid, String name, String email, String mobile) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        Mobile = mobile;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}

