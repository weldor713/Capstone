/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.cms.dao;

import com.aegis.cms.model.User;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface CmsUserManDao {

    public void addUser(User newUser);

    public void deleteUser(int id);

    public List<User> getAllUsers();

    public void editUser(User user);
    
    public User getUserById(int id);

}
