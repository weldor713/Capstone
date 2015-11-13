package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CmsCreateJdbcImpl implements CmsCreateDao {

    private JdbcTemplate templ;

    public void setJdbcTemplate(JdbcTemplate templ) {
        this.templ = templ;
    }

    //Post Crud
    private static final String SQL_ADD_POST
            = "insert into post (title, body, postDate, expiration, isPublished) "
            + "values (?, ?, ?, ?, ?)";

    //Post_Tag    
    private static final String SQL_INSERT_POST_TAG
            = "insert into post_tag (post_id, tag_id) values(?, ?)";

    //Tag Crud
    private static final String SQL_ADD_TAG
            = "insert into tag (tagName) "
            + "values (?)";
    private static final String SQL_GET_TAG
            = "select * from tag "
            + "where tagName = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPost(Post post) {
        templ.update(SQL_ADD_POST,
                post.getTitle(),
                post.getBody(),
                post.getPostDate(),
                post.getExpiration(),
                post.getIsPublished());
        post.setPostId(templ.queryForObject("select LAST_INSERT_ID()", Integer.class));
        insertPostTag(post);
    }

    private void insertPostTag(Post post) {
        int postId = post.getPostId();
        Set<Tag> tags = post.getTags();
        int[] tagIds = new int[tags.size()];
        int counter = 0;
        for (Tag t : tags) {
            try {
                templ.update(SQL_ADD_TAG,
                        t.getTagName());
                t.setTagId(templ.queryForObject("select LAST_INSERT_ID()", Integer.class));
            } catch (DuplicateKeyException ex) {
                Tag dbTag = templ.queryForObject(SQL_GET_TAG, new TagMapper(), t.getTagName());
                t.setTagId(dbTag.getTagId());
            }
           
            tagIds[counter] = t.getTagId();
            counter++;
        }

        templ.batchUpdate(SQL_INSERT_POST_TAG, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, postId);
                ps.setInt(2, tagIds[i]);
            }

            @Override
            public int getBatchSize() {
                return tagIds.length;
            }

        });
    }

    private static final class TagMapper implements ParameterizedRowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag tag = new Tag();
            tag.setTagId(rs.getInt("tag_id"));
            tag.setTagName(rs.getString("tagName"));
            return tag;
        }
    }
}
