package com.hyz.springbooteveryday.service;

import com.hyz.springbooteveryday.entity.UserDO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author HYZ
 * @Created 2021/9/5
 */
public class Stream {

    /**
     * 将List 对象按照参数转换成Map<String, Map<Integer, Integer>
     * @param userDOS
     * @return
     */
    public static Map<Integer, Map<Integer, List<UserDO>>> groupMapListObject(List<UserDO>userDOS) {
        return userDOS.stream().collect(Collectors.groupingBy(UserDO::getSex,
                Collectors.groupingBy(UserDO::getAge,
                        Collectors.toList())));
    }

    /**
     *
     * @param userDOS
     * @return
     */
    public static Map<Integer, Map<Integer,  String>> groupMapListParam(List<UserDO>userDOS) {
        return userDOS.stream().collect(Collectors.groupingBy(UserDO::getSex,
                        Collectors.toMap(UserDO::getAge, UserDO::getName,
                                (oldValue, newValue) -> oldValue)));
    }
}
