package com.aegis.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserManagerController {
    
    @RequestMapping(value="/userMan", method=RequestMethod.GET)
    public String displayUserManager(){
        return "userManager";
    }
}
