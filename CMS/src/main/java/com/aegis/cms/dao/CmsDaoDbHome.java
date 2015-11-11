package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.StaticContent;
import com.aegis.cms.model.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class CmsDaoDbHome implements CmsDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_SELECT_ALL_POSTS = "select * from post order by postDate asc";
    private static final String SQL_SELECT_POST_TAG_TAG_ID_BY_POST_ID
            = "select tag_id from post_tag where post_id = ?";
    private static final String SQL_SELECT_TAG = "select * from tag where tag_id = ?";
    private static final String SQL_SELECT_ALL_TAGS = "select * from tag";
    private static final String SQL_SELECT_POSTS_BY_TAG_ID
            = "select p.post_id, p.title, p.body, p.postDate, p.expiration "
            + "from post p join post_tag pt on tag_id where p.post_id  = pt.post_id and pt.tag_id  =  ? "
            + "order by postDate asc";

    // HOME PAGE METHODS
    public List<Post> getAllPosts() {
        List<Post> postList = jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new PostMapper());
        for (Post post : postList) {
            post.setTags(getTagsForPost(post));
        }
        return postList;
    }
    
    @Override
    public List<Post> getAllPostsByTag(int id){
        List<Post> postList = jdbcTemplate.query(SQL_SELECT_POSTS_BY_TAG_ID, new PostMapper(), id);
        for (Post post : postList) {
            post.setTags(getTagsForPost(post));
        }
        return postList;
    }

    private Set<Tag> getTagsForPost(Post post) {
        Set<Tag> tagSet = new HashSet<>();
        List<Integer> tagIds = jdbcTemplate.queryForList(SQL_SELECT_POST_TAG_TAG_ID_BY_POST_ID,
                new Integer[]{post.getPostId()}, Integer.class);
          for (int i = 0; i < tagIds.size(); i++){
              Tag tempTag = new Tag();
              int tempTagId = tagIds.get(i);
              tempTag = getTagById(tempTagId);
              tagSet.add(tempTag);
          }
        return tagSet;
    }

    public Tag getTagById(int tagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_TAG, new TagMapper(), tagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Tag> getAllTags() {
        return jdbcTemplate.query(SQL_SELECT_ALL_TAGS, new TagMapper());
    }
    
    

    // OTHER METHODS
    public void addPost(Post post) {}
    public void addTag(Tag tag) {}
    public void addStaticContent(StaticContent cont) {}
    public StaticContent getStaticContent() {
        StaticContent sc = new StaticContent();
        return sc;
    }
    public void updateStaticContent(StaticContent cont) {}
    public void deleteStaticContent(StaticContent cont) {}

    // MAPPERS
    private static final class PostMapper implements ParameterizedRowMapper<Post> {
        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post post = new Post();
            post.setPostId(rs.getInt("post_id"));
            post.setTitle(rs.getString("title"));
            post.setBody(rs.getString("body"));
            post.setPostDate(rs.getDate("postDate"));
            post.setExpiration(rs.getDate("expiration"));
            return post;
        }
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
