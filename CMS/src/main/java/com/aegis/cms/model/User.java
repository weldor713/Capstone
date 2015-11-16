package com.aegis.cms.model;

import java.util.ArrayList;

public class User {

    private int userId;
    private String userName;
    private String password;
//    private boolean isEnabled;
    private String publicName;
    private String authority;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public boolean getIsEnabled() {
//        return isEnabled;
//    }
//
//    public void setIsEnabled(boolean isEnabled) {
//        this.isEnabled = isEnabled;
//    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
