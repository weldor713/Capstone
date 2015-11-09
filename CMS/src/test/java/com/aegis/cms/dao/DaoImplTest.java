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
//import java.util.Set;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author apprentice
// */
//public class DaoImplTest {
//
//    private final Tag ta = new Tag();
//    private final Tag tb = new Tag();
//    private final Post pa = new Post();
//    private final Post pb = new Post();
//    private static DaoImpl instance;
//
////    public DaoImplTest() {
////    }
////
////    @BeforeClass
////
////    public static void setUpClass() {
////        instance = new DaoImpl();
////    }
////
////    @AfterClass
////    public static void tearDownClass() throws Exception {
////    }
////
////    @Before
////    public void setUp() throws Exception {
////    }
////
////    @After
////    public void tearDown() throws Exception {
////    }
////
////    /**
////     * Test of createTag method, of class DaoImpl.
////     */
////    @Test
////    public void testCreateTag() {
////        System.out.println("createTag");
////        Tag result = instance.createTag(ta);
////        Tag result2 = instance.createTag(tb);
////        assertTrue(instance.viewAllTags().size() == 3);
////
////    }
////
////    /**
////     * Test of readTag method, of class DaoImpl.
////     */
////    @Test
////    public void testReadTag() {
////        instance.createTag(ta);
////
////        System.out.println("readTag");
////        Tag result = instance.readTag(0);
////        Tag failTag = instance.readTag(999999999);
////        assertFalse(failTag instanceof Tag);
////        assertTrue(result instanceof Tag);
////    }
////
////    /**
////     * Test of updateTag method, of class DaoImpl.
////     */
//////    @Test
//////    public void testUpdateTag() {
//////        System.out.println("updateTag");
//////        Tag t = null;
//////        DaoImpl instance = new DaoImpl();
//////        instance.updateTag(t);
//////    }
////    /**
////     * Test of deleteTag method, of class DaoImpl.
////     */
//////    @Test
//////    public void testDeleteTag() {
//////        System.out.println("deleteTag");
//////        int id = 0;
//////        DaoImpl instance = new DaoImpl();
//////        instance.deleteTag(id);
//////    }
////    /**
////     * Test of viewTagsByPost method, of class DaoImpl.
////     */
////    @Test
////    public void testViewTagsByPost() {
////        System.out.println("viewTagsByPost");
////        DaoImpl instance = new DaoImpl();
////        Set<Tag> expResult = null;
////        Set<Tag> result = instance.viewTagsByPost();
////        assertEquals(expResult, result);
////    }
////
////    /**
////     * Test of viewPostsByTag method, of class DaoImpl.
////     */
////    @Test
////    public void testViewPostsByTag() {
////        System.out.println("viewPostsByTag");
////        DaoImpl instance = new DaoImpl();
////        Set<Post> expResult = null;
////        Set<Post> result = instance.viewPostsByTag();
////        assertEquals(expResult, result);
////    }
////
////    /**
////     * Test of viewAllPost method, of class DaoImpl.
////     */
////    @Test
////    public void testViewAllPost() {
////        
////        System.out.println("viewAllPost");
////        assertTrue(instance.viewAllPost().size() == 0);
////        instance.createTag(ta);
////        assertTrue(instance.viewAllPost().size() == 1);
////    }
////
////    /**
////     * Test of viewAllTags method, of class DaoImpl.
////     */
////    @Test
////    public void testViewAllTags() {
////        System.out.println("viewAllTags");
////        DaoImpl instance = new DaoImpl();
////        List<Tag> expResult = null;
////        List<Tag> result = instance.viewAllTags();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//}
