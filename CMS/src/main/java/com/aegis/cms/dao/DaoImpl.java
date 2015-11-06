/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class DaoImpl implements Dao{

   private Map<Integer, Tag> tagMap = new HashMap<>();
   private Map<Integer, Post> postMap = new HashMap<>();
   private static int creationCounter = 0;

    @Override
    public Tag createTag(Tag t) {
        t.setTagId(creationCounter);
        creationCounter ++;
        tagMap.put(t.getTagId(),t);
        return t;
    }

    @Override
    public Tag readTag(int id) {
        return tagMap.get(id);
    }

    @Override
    public void updateTag(Tag t) {
        tagMap.put(t.getTagId(), t);
    }

    @Override
    public void deleteTag(int id) {
         tagMap.remove(id);
    }
    
     @Override
    public Set<Tag> viewTagsByPost() {
       return null;         //TODO finish method 
    }

    @Override
    public Set<Post> viewPostsByTag() {
        return null;        //TODO finish method
    }

    @Override
    public List<Post> viewAllPost() {
        Collection<Post> post;
        post = postMap.values();
        return new ArrayList(post);
    }
    
}
