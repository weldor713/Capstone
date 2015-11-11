package com.aegis.cms.controller;

import com.aegis.cms.dao.CmsUserManDao;
import com.aegis.cms.model.User;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserManagerController {

    private CmsUserManDao userManDao;

    @Inject
    public UserManagerController(CmsUserManDao userManDao) {
        this.userManDao = userManDao;
    }

    // #1 - This endpoint retrieves all users from the database and puts the
    //List of users on the model
    
    @RequestMapping(value="/displayUserList", method=RequestMethod.GET)
    public String displayUserList(Map<String, Object> model) {
        List users = userManDao.getAllUsers();                            
        model.put("users", users);
        return "displayUserList";
    }
// #2 - This endpoint just displays the Add User form

    @RequestMapping(value = "/displayUserForm", method = RequestMethod.GET)
    public String displayUserForm(Map<String, Object> model) {
        return "addUserForm";
    }
// #3 - This endpoint processes the form data and creates a new User

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest req) {
        User newUser = new User();
        
        
        // #4 - This example uses a plain HTML form so we must get values from the request
        newUser.setUserName(req.getParameter("username"));
        newUser.setPassword(req.getParameter("password"));
// #5 - All users have ROLE_USER, only add ROLE_ADMIN if the isAdmin box is checked

        newUser.addAuthority("ROLE_USER");
        if (null != req.getParameter("isAdmin")) {
            newUser.addAuthority("ROLE_ADMIN");
        }
        userManDao.addUser(newUser);
        return "redirect:displayUserList";
    }
// #6 - This endpoint deletes the specified User

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deletUser(@RequestParam("username") String username,
            Map<String, Object> model) {
        userManDao.deleteUser(username);
        return "redirect:displayUserList";
    }
}
        
//        
//
//        @RequestMapping(value = "/userMan", method = RequestMethod.GET)
//        public String displayUserManager
//        
//            (){
//        return "userManager";
//        }
//    }
