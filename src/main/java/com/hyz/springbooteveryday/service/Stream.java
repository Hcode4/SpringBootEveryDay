package com.hyz.springbooteveryday.service;

import com.hyz.springbooteveryday.entity.UserDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
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


    /**
     * 将Map第二维打平
     *
     * @param mapMap
     * @param binaryOperator
     * @param <J>
     * @param <Q>
     * @param <K>
     * @return
     */
    public static  <J, Q, K> Map<J, K> reduceMap(Map<J, Map<Q, K>> mapMap, BinaryOperator<K> binaryOperator) {

        List<Integer> valueList = new ArrayList<>();

        Map<J, K> result = new HashMap<>();

        for (Map.Entry<J, Map<Q, K>> mapEntry : mapMap.entrySet()) {

            K value = mapEntry.getValue().values().stream().reduce(binaryOperator).orElse(null);

            result.put(mapEntry.getKey(), value);
        }
        return result;
    }
}
