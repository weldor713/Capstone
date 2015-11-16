/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.cms.dao;

import com.aegis.cms.model.Post;
import com.aegis.cms.model.Tag;
import com.aegis.cms.model.User;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class CmsDaoTest {

    private CmsPostTagDao ptDao;
    private CmsUserDao userDao;

    public CmsDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        ptDao = ctx.getBean("cmspt", CmsPostTagDao.class);
        userDao = ctx.getBean("cmsuser", CmsUserDao.class);

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from post");
        cleaner.execute("delete from users");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddPostGetAllPosts() {
        System.out.println("addPost");

        Post tPost = new Post();
        Date date = Calendar.getInstance().getTime();

        tPost.setTitle("Test Post");
        tPost.setBody("This is a test body");
        tPost.setTags("this post, has, two tags");
        tPost.setPostDate(date);
        tPost.setExpiration(null);
        tPost.setIsPublished(true);
        tPost.setAuthor("Larry");

        Post dbPost = ptDao.addPost(tPost);
        assertTrue(ptDao.getAllPosts().size() == 1);
        
        tPost.setPostId(dbPost.getPostId());
        assertEquals(tPost, dbPost);

    }

    @Test
    public void testGetAuthorFromUserNameAddUserDeleteUser() {
        System.out.println("getAuthorFromUserName");
        User user = new User();
        user.setPublicName("Larry Bobby");
        user.setUserName("lb22");
        user.setAuthority("ROLE_ADMIN");
        user.setPassword("1234");
        userDao.addUser(user);
        
        String result = ptDao.getAuthorFromUserName(user.getUserName());
        assertEquals(user.getPublicName(), result);
    }

    @Test
    public void testGetAllVisiblePosts() {
        System.out.println("getAllVisiblePosts");
        List<Post> expResult = null;
        List<Post> result = ptDao.getAllVisiblePosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllTags() {
        System.out.println("getAllTags");
        List<Tag> expResult = null;
        List<Tag> result = ptDao.getAllTags();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllPostsByTag() {
        System.out.println("getAllPostsByTag");
        int id = 0;
        List<Post> expResult = null;
        List<Post> result = ptDao.getAllPostsByTag(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPostById() {
        System.out.println("getPostById");
        int id = 0;
        Post expResult = null;
        Post result = ptDao.getPostById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllPosts() {
        System.out.println("getAllPosts");
        List<Post> expResult = null;
        List<Post> result = ptDao.getAllPosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditPost() {
        System.out.println("editPost");
        Post post = null;
        ptDao.editPost(post);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPublishPost() {
        System.out.println("publishPost");
        int id = 0;
        ptDao.publishPost(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUnpublishPost() {
        System.out.println("unpublishPost");
        int id = 0;
        ptDao.unpublishPost(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
