package com.hyz.springbooteveryday.service;

import com.hyz.springbooteveryday.dao.UserDAO;
import com.hyz.springbooteveryday.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author HYZ
 * @Created 2021/9/5
 */
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StreamTest {


    @Resource
    UserDAO userDAO;

    @Test
    public void groupMapListObjectTest() {
        List<UserDO>userDOList = userDAO.studentAll();
        log.info(userDOList.toString());

        Map<Integer, Map<Integer, List<UserDO>>> groupMapListObject = Stream.groupMapListObject(userDOList);

        log.info(groupMapListObject.toString());

        Map<Integer, Map<Integer,  String>> groupMapListParam = Stream.groupMapListParam(userDOList);
        log.info(groupMapListParam.toString());

    }
}
