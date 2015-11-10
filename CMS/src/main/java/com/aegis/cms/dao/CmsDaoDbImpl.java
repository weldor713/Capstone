
package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.StaticContent;
import com.aegis.cms.model.Tag;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Post> getAllPosts() {
        return (List<Post>) currentSession().createCriteria(Post.class).list();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addStaticContent(StaticContent cont) {
        currentSession().save(cont);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateStaticContent(StaticContent cont) {
        currentSession().update(cont);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteStaticContent(StaticContent cont) {
        currentSession().delete(cont);
    }

    @Override
    public StaticContent getStaticContent() {
        return (StaticContent) currentSession().get(StaticContent.class, 1);
    }

}
