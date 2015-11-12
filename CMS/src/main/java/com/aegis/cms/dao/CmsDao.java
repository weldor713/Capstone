package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.StaticContent;
import com.aegis.cms.model.Tag;
import java.util.List;

public interface CmsDao {

    public void addPost(Post post);

    public void addTag(Tag tag);

    public List<Post> getAllPosts();

    public List<Tag> getAllTags();

    public void addStaticContent(StaticContent cont);

    public StaticContent getStaticContent();

    public void updateStaticContent(StaticContent cont);

    public void deleteStaticContent(StaticContent cont);
    
    public List<Post> getAllPostsByTag(int id);

}
