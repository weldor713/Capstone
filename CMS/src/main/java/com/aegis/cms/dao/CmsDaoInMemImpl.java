package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import java.util.ArrayList;
import java.util.List;

public class CmsDaoInMemImpl implements CmsDao {
    private ArrayList<Post> blog = new ArrayList<>();
    private ArrayList<Tag> tags = new ArrayList<>();
    
    public void addPost(Post post){
        blog.add(post);
    }
    
    public void addTag(Tag tag){
        tags.add(tag);
    }
    
    public List<Post> getAllPosts(){
        return blog;
    }
}
