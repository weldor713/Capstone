/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geas.blog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author apprentice
 */
@Entity
@Table(name="POST")
public class Post {
    
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    int postId;
    
    @Column( name = "TITLE", nullable = false)
    String title;
    
    @Column(name = "BODY")
    String body;
    
    //User author;
//    Set<String> tags;
//    LocalDate datePosted;
//    LocalDate expiration;
    
    @Column(name = "APPROVED")
    boolean approved;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
    
}
