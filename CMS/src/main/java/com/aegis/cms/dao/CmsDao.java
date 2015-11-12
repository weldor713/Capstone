package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.StaticContent;
import com.aegis.cms.model.Tag;
import java.util.List;

public interface CmsDao {

    // Create Post 
    public void addPost(Post post);

    public void addTag(Tag tag);

    // Home Page
    public List<Post> getAllVisiblePosts();

    public List<Tag> getAllTags();

    public List<Post> getAllPostsByTag(int id);

    // Post Manager
    public Post getPostById(int id);

    public List<Post> getAllPosts();

    // Static Content
    public void addStaticContent(StaticContent cont);

    public StaticContent getStaticContent();

    public void updateStaticContent(StaticContent cont);

    public void deleteStaticContent(StaticContent cont);

}
