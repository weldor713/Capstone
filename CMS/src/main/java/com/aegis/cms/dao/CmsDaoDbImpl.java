/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
@Repository
@Transactional
public class CmsDaoDbImpl implements CmsDao {

    private SessionFactory sessionFactory;
    
    @Inject
    public CmsDaoDbImpl(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    
    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void addPost(Post post) {
        currentSession().save(post);
    }

    @Override
    public void addTag(Tag tag) {
        currentSession().save(tag);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Post> getAllPosts() {
        return (List<Post>) currentSession().createCriteria(Post.class).list();
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Tag> getAllTags() {
        return (List<Tag>) currentSession().createCriteria(Tag.class).list();
    }
    
}

