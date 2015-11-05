/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geas.blog.models;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postDAO")
@Transactional
public class PostDAOImpl implements PostDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void persistPost(Post post) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().persist(post);
    }

    @Override
    public Post findPostById(int id) {
        return (Post) sessionFactory.getCurrentSession().get(Post.class, id);
    }

    @Override
    public void updatePost(Post post) {
        sessionFactory.getCurrentSession().update(post);

    }

    @Override
    public void deletePost(Post post) {
        sessionFactory.getCurrentSession().delete(post);
    }

}
