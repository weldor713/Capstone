package com.aegis.cms.controller;

import com.aegis.cms.dao.CmsDao;
import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    CmsDao dao;
    
    @Inject
    public HomeController(CmsDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
    public String displayHome(){
        return "index";
    }
    
    @RequestMapping(value="/posts", method=RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllPosts(){
        return dao.getAllPosts();
    }
    
    @RequestMapping(value="/tags", method=RequestMethod.GET)
    @ResponseBody
    public List<Tag> getAllTags() {
        return dao.getAllTags();
    }
    
}
