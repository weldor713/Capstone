package com.aegis.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostManagerController {
    
    @RequestMapping(value="/postMan", method=RequestMethod.GET)
    public String displayPostManager(){
        return "postManager";
    }
}
