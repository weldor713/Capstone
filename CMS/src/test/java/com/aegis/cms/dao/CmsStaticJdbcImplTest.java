/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.cms.dao;

import com.aegis.cms.model.StaticContent;
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
public class CmsStaticJdbcImplTest {

    private CmsStaticDao dao;

    public CmsStaticJdbcImplTest() {
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
        dao = ctx.getBean("cmsStatic", CmsStaticDao.class);
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from static_content");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addStaticContent method, of class CmsStaticJdbcImpl.
     */
    @Test
    public void testAddStaticContent() {
        StaticContent tContent = new StaticContent();
        tContent.setContent("LOLOL");
        tContent.setContentId(1);
        dao.addStaticContent(tContent);
        StaticContent fromDb = dao.getStaticContent();
        assertTrue(fromDb instanceof StaticContent);

    }

    /**
     * Test of getStaticContent method, of class CmsStaticJdbcImpl.
     */
    @Test
    public void testGetStaticContent() {
        StaticContent tContent = new StaticContent();
        tContent.setContent("LOLOL");
        tContent.setContentId(1);
        dao.addStaticContent(tContent);
        System.out.println(dao.getStaticContent().getContent());
        assertTrue(dao.getStaticContent() instanceof StaticContent);
    }

    /**
     * Test of updateStaticContent method, of class CmsStaticJdbcImpl.
     */
    @Test
    public void testUpdateStaticContent() {
        StaticContent tContent = new StaticContent();
        tContent.setContent("LOLOL");
        tContent.setContentId(1);
        StaticContent tContentUpdate = new StaticContent();
        tContent.setContent("LOLOLOL");
        tContent.setContentId(1);
        dao.addStaticContent(tContent);
        dao.updateStaticContent(tContentUpdate);
        //System.out.println(tContentUpdate.getContent());
        assertEquals("LOLOLOL", dao.getStaticContent().getContent());
    }

    /**
     * Test of deleteStaticContent method, of class CmsStaticJdbcImpl.
     */
    
    @Test
    public void testDeleteStaticContent() {
        StaticContent tContent = new StaticContent();
        tContent.setContent("LOLOL");
        tContent.setContentId(1);
        dao.addStaticContent(tContent);
        assertTrue(dao.getStaticContent() != null);
        dao.deleteStaticContent(tContent);
        assertNull(dao.getStaticContent());
    }
    
}
