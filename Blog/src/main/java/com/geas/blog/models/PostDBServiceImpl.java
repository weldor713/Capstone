/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geas.blog.models;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author apprentice
 */
@Service("postService")
public class PostDBServiceImpl implements PostDBService {
    
    @Autowired
    PostDAO postDAO;

    @Override
    @Transactional
    public void persistPost(Post post) {
        postDAO.persistPost(post);

    }

    @Override
    @Transactional
    public Post findPostById(int id) {
        return postDAO.findPostById(id);
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        postDAO.updatePost(post);
    }

    @Override
    @Transactional
    public void deletePost(Post post) {
        postDAO.deletePost(post);
    }

}
