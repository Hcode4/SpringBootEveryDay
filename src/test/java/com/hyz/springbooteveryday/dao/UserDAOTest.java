package com.hyz.springbooteveryday.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author HYZ
 * @Created 2021/8/29
 */
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {

    @Resource
    UserDAO userDAO;

    @Test
    public void studentCountTest() {
        log.info(userDAO.studentAll().toString());

    }

}
