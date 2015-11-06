package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;

public interface CmsDao {
    public void addPost(Post post);
    public void addTag(Tag tag);
}
