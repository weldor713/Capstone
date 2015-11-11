/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.cms.dao;

import com.aegis.cms.model.User;

/**
 *
 * @author apprentice
 */
public interface CmsUserManDao {
    
public User addUser (User newUser);

public void deleteUser (String username);

//public User getAllUsers (User username);   //fix this one
//    
}
