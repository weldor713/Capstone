/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.cms.dao;

/**
 *
 * @author apprentice
 */
public class UserDaoDbImpl implements CmsUserManDao {

    // #1 - We need to update both the users and authorities tables
    private static final String SQL_INSERT_USER =
        "insert into users (username, password, enabled) values (?, ?, 1)";
    
    private static final
"insert into
private static final
"delete from
private static final
"delete from
String SQL_INSERT_AUTHORITY =
authorities (username, authority) values (?, ?)";
String SQL_DELETE_USER =
users where username = ?";
String SQL_DELETE_AUTHORITIES =
authorities where username = ?";
private JdbcTemplate jdbcTemplate;
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
this.jdbcTemplate = jdbcTemplate;
}
@Override
public User addUser(User newUser) {
// #2 - First insert user data into the users table and then insert
data into
//
the authorities table (failing to do so will result in
foreign key
//
constraint errors)
jdbcTemplate.update(SQL_INSERT_USER, newUser.getUsername(),
newUser.getPassword());
newUser.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
Integer.class));
    


    }
