package com.aegis.cms.controller;

import com.aegis.cms.dao.CmsDao;
import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class CreatePostsController {
    private CmsDao dao;
    
    @Inject
    public CreatePostsController(CmsDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value="/createPosts", method=RequestMethod.GET)
    public String displayCreatePosts(){
        return "createPosts";
    }
    
    @RequestMapping(value="/post", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addPost(@RequestBody Post post){
        dao.addPost(post);
    }
    
    @RequestMapping(value="/tag", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addtag(@RequestBody Tag tag){
        dao.addTag(tag);ggit
    }
}