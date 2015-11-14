///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.aegis.cms.dao;
//
//import com.aegis.cms.model.Post;
//import com.aegis.cms.model.Tag;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// *
// * @author apprentice
// */
//public class CmsDaoTest {
//
//    private CmsPostTagDao dao;
//
//    public CmsDaoTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        ApplicationContext ctx
//                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        dao = ctx.getBean("cmspt", CmsPostTagDao.class);
//
//        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//        cleaner.execute("delete from post");
//
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testAddPost() {
//        System.out.println("addPost");
//
////        Date date = new Date();
////        Post tPost = new Post();
////        tPost.setBody("LOLOL");
////        tPost.setExpiration(date);
////        tPost.setPostDate(date);
////        tPost.setTags("A Bay Bay");
////        tPost.setTitle("Test Post");
////        tPost.setIsPublished(true);
////        System.out.println(tPost);
////        dao.addPost(tPost);
//        Post post = null;
//        dao.addPost(post);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAuthorFromUserName() {
//        System.out.println("getAuthorFromUserName");
//        String username = "";
//        String expResult = "";
//        String result = dao.getAuthorFromUserName(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllVisiblePosts() {
//        System.out.println("getAllVisiblePosts");
//        List<Post> expResult = null;
//        List<Post> result = dao.getAllVisiblePosts();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllTags() {
//        System.out.println("getAllTags");
//        List<Tag> expResult = null;
//        List<Tag> result = dao.getAllTags();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllPostsByTag() {
//        System.out.println("getAllPostsByTag");
//        int id = 0;
//        List<Post> expResult = null;
//        List<Post> result = dao.getAllPostsByTag(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetPostById() {
//        System.out.println("getPostById");
//        int id = 0;
//        Post expResult = null;
//        Post result = dao.getPostById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllPosts() {
//        System.out.println("getAllPosts");
//        List<Post> expResult = null;
//        List<Post> result = dao.getAllPosts();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testEditPost() {
//        System.out.println("editPost");
//        Post post = null;
//        dao.editPost(post);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testPublishPost() {
//        System.out.println("publishPost");
//        int id = 0;
//        dao.publishPost(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUnpublishPost() {
//        System.out.println("unpublishPost");
//        int id = 0;
//        dao.unpublishPost(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//}
