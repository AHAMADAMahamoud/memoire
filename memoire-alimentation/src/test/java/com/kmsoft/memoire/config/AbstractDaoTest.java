package com.kmsoft.memoire.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kmsoft.memoire.alimentation.dw.config.ApplicationConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public abstract class AbstractDaoTest extends AbstractJUnit4SpringContextTests {

    /**
     * Constructor
     *
     */
    public AbstractDaoTest() {
        super();
    }
}