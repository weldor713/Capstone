package com.aegis.cms.dao;

import com.aegis.cms.model.StaticContent;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CmsStaticJdbcImpl implements CmsStaticDao {

    private JdbcTemplate templ;

    public void setJdbcTemplate(JdbcTemplate templ) {
        this.templ = templ;
    }

    //Static Content CRUD
    private static final String SQL_ADD_STATIC_CONTENT
            = "insert into static_content (content_id, content) "
            + "values(?, ?)";
    private static final String SQL_GET_STATIC_CONTENT
            = "select * from static_content where content_id = ?";
    private static final String SQL_UPDATE_STATIC_CONTENT
            = "update static_content"
            + "set content = ?"
            + "where content_id = ?";
    private static final String SQL_DELETE_STATIC_CONTENT
            = "delete from static_content where content_id = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addStaticContent(StaticContent cont) {
        templ.update(SQL_ADD_STATIC_CONTENT,
                cont.getContentId(),
                cont.getContent());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public StaticContent getStaticContent() {
        try {
            return templ.queryForObject(SQL_GET_STATIC_CONTENT, StaticContent.class, 1);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateStaticContent(StaticContent cont) {
        templ.update(SQL_ADD_STATIC_CONTENT,
                cont.getContentId(),
                cont.getContent());
    }

    @Override
    public void deleteStaticContent(StaticContent cont) {
        templ.update(SQL_DELETE_STATIC_CONTENT, cont.getContentId());
    }

}
