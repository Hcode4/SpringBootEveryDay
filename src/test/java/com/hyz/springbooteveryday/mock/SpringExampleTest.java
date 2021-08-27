package com.hyz.springbooteveryday.mock;

import com.hyz.springbooteveryday.service.FinalClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author HYZ
 * @Created 2021/8/22
 */
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringExampleTest {


    @Autowired
    FinalClass finalClass;

    @Test
    public void testFinalClass() {
        log.info("begin");
        finalClass.sayHello();
        log.info("end");
    }
}
