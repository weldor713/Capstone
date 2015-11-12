package com.aegis.cms.controller;

import com.aegis.cms.dao.CmsDao;
import com.aegis.cms.model.Post;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostManagerController {

    CmsDao dao;

    @Inject
    public PostManagerController(CmsDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/postMan", method = RequestMethod.GET)
    public String displayPostManager() {
        return "postManager";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getPostById(@PathVariable("id") int id) {
        return dao.getPostById(id);
    }
    
    @RequestMapping(value = "/allposts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllPosts() {
        return dao.getAllPosts();
    }
}
