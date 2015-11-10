
package com.aegis.cms.model;

import java.io.Serializable;

public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;


    private int userId;
    private String userName;
    private String password;
    private boolean isEnabled;
    private String publicName;

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

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }
    
        public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isIsEnabled() {
        return isEnabled;
    }
}
