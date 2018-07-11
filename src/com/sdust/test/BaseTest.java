package com.sdust.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)             //����spring-test
@ContextConfiguration("/applicationContext.xml")    //����spring����
public class BaseTest {
    @Test
    @Transactional
    @Rollback(false)
    public void ttt(){

    }
}
