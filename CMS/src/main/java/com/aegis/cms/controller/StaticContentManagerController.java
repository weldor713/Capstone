package com.aegis.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticContentManagerController {
    
    @RequestMapping(value="/staticMan", method=RequestMethod.GET)
    public String displayStaticContentManager(){
        return "staticContentManager";
    }
}
