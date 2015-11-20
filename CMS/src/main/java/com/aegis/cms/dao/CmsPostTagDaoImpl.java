package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CmsPostTagDaoImpl implements CmsPostTagDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Post Queries
    private static final String SQL_SELECT_ALL_POSTS
            = "select * from post ";
            //+ "order by postdate desc, post_id desc ";
    private static final String SQL_SELECT_ALL_EXPIRED
            = "select * from post "
            + "where now()::date > expiration "
            + "order by postdate desc, post_id desc ";
    private static final String SQL_SELECT_ALL_UNPUBLISHED
            = "select * from post "
            + "where ispublished = 0 "
            + "order by postdate desc, post_id desc ";
    private static final String SQL_SELECT_ALL_VISIBLE_POSTS
            = "select * from post "
            + "where ispublished = 1"
            + "AND postdate <= now()::date "
            + "AND (expiration > now()::date "
            + "OR expiration IS NULL) "
            + "order by postdate desc, post_id desc";
    private static final String SQL_SELECT_POSTS_BY_TAG_ID
            = "select * from post p "
            + "join post_tag pt on tag_id = pt.tag_id "
            + "where p.post_id  = pt.post_id "
            + "and pt.tag_id = ? and p.ispublished = 1 "
            + "order by p.postdate desc, p.post_id desc";
    private static final String SQL_SELECT_POST
            = "select * from post where post_id = ?";
    private static final String SQL_UPDATE_POST_PUB_UNPUB
            ="update post set ispublished = ? where post_id = ?";
    private static final String SQL_UPDATE_POST
            ="update post "
            + "set title = ?, body = ?, postdate = ?, expiration = ? "
            + "where post_id = ?";
    private static final String SQL_ADD_POST
            = "insert into post (title, body, postdate, expiration, ispublished, author) "
            + "values (?, ?, ?, ?, ?, ?)";
    
    //user queries
    private static final String SQL_GET_PUBNAME_BY_USERNAME
            = "select publicname from users where username = ?";

    //post_tag queries
    private static final String SQL_SELECT_POST_TAG_TAG_ID_BY_POST_ID
            = "select tag_id from post_tag "
            + "where post_id = ?";
    private static final String SQL_INSERT_POST_TAG
            = "insert into post_tag (post_id, tag_id) values(?, ?)";
    private static final String SQL_DELETE_POST_TAG 
            = "delete from post_tag "
            + "where post_id = ?";
    private static final String SQL_DELETE_POST 
            = "delete from post "
            + "where post_id = ?";

    // tag queries
    private static final String SQL_SELECT_TAG
            = "select * from tag "
            + "where tag_id = ?";
    private static final String SQL_SELECT_ALL_TAGS
            = "select distinct t.tag_id, t.tagname from tag t "
            + "join post_tag pt on t.tag_id = pt.tag_id "
            + "join post p on pt.post_id = p.post_id "
            + "where p.ispublished = 1 AND p.postdate <= now()::date AND (now()::date < p.expiration OR p.expiration IS NULL) ";
    private static final String SQL_ADD_TAG
            = "insert into tag (tagname) "
            + "values (?)";
    private static final String SQL_GET_TAG
            = "select * from tag "
            + "where tagname = ?";

    // HOME PAGE METHODS
    @Override
    public List<Post> getAllVisiblePosts() {
        List<Post> postList = jdbcTemplate.query(SQL_SELECT_ALL_VISIBLE_POSTS, new PostMapper());
        for (Post post : postList) {
            post.setTagsFromDb(getTagsForPost(post));
        }
        return postList;
    }

    @Override
    public List<Post> getAllPostsByTag(int id) {
        List<Post> postList = jdbcTemplate.query(SQL_SELECT_POSTS_BY_TAG_ID, new PostMapper(), id);
        for (Post post : postList) {
            post.setTagsFromDb(getTagsForPost(post));
        }
        return postList;
    }

    @Override
    public List<Tag> getAllTags() {
        return jdbcTemplate.query(SQL_SELECT_ALL_TAGS, new TagMapper());
    }
    
    // CREATE POST METHODS
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post addPost(Post post) {
        jdbcTemplate.update(SQL_ADD_POST,
                post.getTitle(),
                post.getBody(),
                post.getPostDate(),
                post.getExpiration(),
                1,
                post.getAuthor());
        post.setPostId(jdbcTemplate.queryForObject("select nextval('post_post_id_seq')", Integer.class));
        insertPostTag(post);
        
        return post;
    }
    
    @Override
    public String getAuthorFromUserName(String username){
        return jdbcTemplate.queryForObject(SQL_GET_PUBNAME_BY_USERNAME, String.class, username);
    }

    // POST MANAGER METHODS
    @Override
    public Post getPostById(int id) {
        Post post = jdbcTemplate.queryForObject(SQL_SELECT_POST, new PostMapper(), id);
        post.setTagsFromDb(getTagsForPost(post));
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> postList = jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new PostMapper());
        for (Post post : postList) {
            post.setTagsFromDb(getTagsForPost(post));
        }
        return postList;
    }
    
    @Override
    public List<Post> getAllExpired() {
        List<Post> postList = jdbcTemplate.query(SQL_SELECT_ALL_EXPIRED, new PostMapper());
        for (Post post : postList) {
            post.setTagsFromDb(getTagsForPost(post));
        }
        return postList;
    }
    
    @Override
    public List<Post> getAllUnpublished() {
        List<Post> postList = jdbcTemplate.query(SQL_SELECT_ALL_UNPUBLISHED, new PostMapper());
        for (Post post : postList) {
            post.setTagsFromDb(getTagsForPost(post));
        }
        return postList;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editPost(Post post){
        jdbcTemplate.update(SQL_UPDATE_POST,
                post.getTitle(),
                post.getBody(),
                post.getPostDate(),
                post.getExpiration(),
                post.getPostId());
        deletePostTag(post);
        insertPostTag(post);
    }
    
    @Override
    public void publishPost(int id){
        jdbcTemplate.update(SQL_UPDATE_POST_PUB_UNPUB, 1, id);
    }
    
    @Override
    public void unpublishPost(int id){
        jdbcTemplate.update(SQL_UPDATE_POST_PUB_UNPUB, 0, id);
    }
    
    @Override
    public void deletePostTagById(int id) {
        jdbcTemplate.update(SQL_DELETE_POST, id);
    }

    // HELPER METHODS
    private Set<Tag> getTagsForPost(Post post) {
        Set<Tag> tagSet = new HashSet<>();
        List<Integer> tagIds = jdbcTemplate.queryForList(SQL_SELECT_POST_TAG_TAG_ID_BY_POST_ID,
                new Integer[]{post.getPostId()}, Integer.class);
        for (int i = 0; i < tagIds.size(); i++) {
            Tag tempTag = new Tag();
            int tempTagId = tagIds.get(i);
            tempTag = getTagById(tempTagId);
            tagSet.add(tempTag);
        }
        return tagSet;
    }

    private Tag getTagById(int tagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_TAG, new TagMapper(), tagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private void insertPostTag(Post post) {
        int postId = post.getPostId();
        Set<Tag> tags = post.getTags();
        int[] tagIds = new int[tags.size()];
        int counter = 0;
        for (Tag t : tags) {
            try {
                jdbcTemplate.update(SQL_ADD_TAG,
                        t.getTagName());
                t.setTagId(jdbcTemplate.queryForObject("select nextval('tag_tag_id_seq')", Integer.class));
            } catch (DuplicateKeyException ex) {
                Tag dbTag = jdbcTemplate.queryForObject(SQL_GET_TAG, new TagMapper(), t.getTagName());
                t.setTagId(dbTag.getTagId());
            }
           
            tagIds[counter] = t.getTagId();
            counter++;
        }
    
        jdbcTemplate.batchUpdate(SQL_INSERT_POST_TAG, new BatchPreparedStatementSetter() {
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
    
    private void deletePostTag(Post post) {
        jdbcTemplate.update(SQL_DELETE_POST_TAG, post.getPostId());
    }

    // MAPPERS
    private static final class PostMapper implements ParameterizedRowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post post = new Post();
            post.setPostId(rs.getInt("post_id"));
            post.setTitle(rs.getString("title"));
            post.setBody(rs.getString("body"));
            post.setPostDate(rs.getDate("postdate"));
            post.setExpiration(rs.getDate("expiration"));
            post.setIsPublished(rs.getBoolean("ispublished"));
            post.setAuthor(rs.getString("author"));
            return post;
        }
    }

    private static final class TagMapper implements ParameterizedRowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag tag = new Tag();
            tag.setTagId(rs.getInt("tag_id"));
            tag.setTagName(rs.getString("tagname"));
            return tag;
        }
    }
}
