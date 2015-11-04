/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this ttestPostplate file, choose Tools | TtestPostplates
 * and open the ttestPostplate in the editor.
 */
package com.geas.blog.blog;

import com.geas.blog.models.Post;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.geas.blog.models.PostDBService;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {

        System.out.println("load context");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Post testPost = new Post();
        testPost.setPostId(1);
        testPost.setTitle("John");
        testPost.setBody("l;asdfja;lsdkfj;ladsfj;l;ldkskfja;sldfkja;lsdfjaf;lfdjkas;dlfja;ldsfkja;dlfk");
        PostDBService testPostService = (PostDBService) context.getBean("postService");
        testPostService.persistPost(testPost);
        System.out.println("Updated title :" + testPostService.findPostById(1).getTitle());      
        testPost.setTitle("Hello");
        testPostService.updatePost(testPost);
        System.out.println("Updated title :" + testPostService.findPostById(1).getTitle());
        testPostService.deletePost(testPost);
        context.close();
    }

}
