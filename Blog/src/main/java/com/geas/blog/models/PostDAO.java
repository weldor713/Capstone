/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geas.blog.models;

/**
 *
 * @author apprentice
 */
interface PostDAO {

    void persistPost(Post employee);

    Post findPostById(int id);

    void updatePost(Post employee);

    void deletePost(Post employee);
}
