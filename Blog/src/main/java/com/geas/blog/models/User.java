/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geas.blog.models;

import com.geas.blog.blog.Role;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    //maybe just use one
    private String nickName;
    private String userName;
    private String password;
    private String role;
    private ArrayList<Post> ownedBlogs;
    
    
    public User() {
        
    }
    
    public User(String firstName, String lastName, String userName, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    
        public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.role = "user";
    }
    
}
