package com.aegis.cms.controller;

import com.aegis.cms.dao.CmsCreateDao;
import com.aegis.cms.model.Post;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CreatePostsController {

    private CmsCreateDao dao;

    @Inject
    public CreatePostsController(CmsCreateDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/createPosts", method = RequestMethod.GET)
    public String displayCreatePosts() {
        return "createPosts";
    }

    @RequestMapping(value = "/makePost", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Post addPost(@RequestBody Post post, HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            post.setIsPublished('Y');
            dao.addPost(post);
        } else if (request.isUserInRole("ROLE_USER")) {
            post.setIsPublished('N');
            dao.addPost(post);
        }
        return post;
    }

    /*
     @RequestMapping(value="/addTag", method=RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void addtag(@RequestBody String tag){
     dao.addTag(tag);
     }
     */
}
