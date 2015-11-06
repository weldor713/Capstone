/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.cms.controller;

import com.aegis.cms.dao.Dao;
import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class BlogController {
    private Dao dao;

    @Inject
    public void BlogController(Dao dao){
    this.dao = dao;
    }
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping(value = "/Posts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> viewAllPublishedPosts() {
        return dao.viewAllPost();
    }

    @RequestMapping(value = "/Tags", method = RequestMethod.POST)
    @ResponseBody
    public Tag createTag(@Valid @RequestBody Tag t) {
        dao.createTag(t);
        return t;
    }

    @RequestMapping(value = "/Tags/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tag readTag(@PathVariable("id")int id) {
        return dao.readTag(id);
    }

    @RequestMapping(value = "/Tags/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTag(@PathVariable("id")int id, @RequestBody Tag t) {
        t.setTagId(id);
        dao.updateTag(t);
    }

    @RequestMapping(value = "/Tags/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable("id")int id) {
        dao.deleteTag(id);
    }

    @RequestMapping(value = "/Tags", method = RequestMethod.GET)
    @ResponseBody
    public Set<Tag> viewAllTags(Post post) {
        return dao.viewTagsByPost();
    }

    @RequestMapping(value = "/Tags/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Set<Post> viewPostsByTag(Tag tag) {
        return dao.viewPostsByTag();
    }

}
