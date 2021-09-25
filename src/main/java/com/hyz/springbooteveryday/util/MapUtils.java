package com.hyz.springbooteveryday.util;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author HYZ
 * @Created 2021/9/24
 */
public class MapUtils {

    /**
     * Map 两层 key 反转
     *
     * @param firstSecondMapMap
     * @param <T>
     * @return
     */
    public static <T> Map<String, Map<String, T>> reverseMapLevel(Map<String, Map<String, T>> firstSecondMapMap) {

        Map<String, Map<String, T>> secondFirstMapMap = new HashMap<>();

        for (Map.Entry<String, Map<String, T>> firstSecondMapEntry : firstSecondMapMap.entrySet()) {
            if (CollectionUtils.isEmpty(firstSecondMapEntry.getValue())) {
                continue;
            }
            for (Map.Entry<String, T> firstMapEntry : firstSecondMapEntry.getValue().entrySet()) {
                Map<String, T> firstMapTemplate = secondFirstMapMap.getOrDefault(firstMapEntry.getKey(), new HashMap<>());
                firstMapTemplate.put(firstSecondMapEntry.getKey(), firstMapEntry.getValue());
                secondFirstMapMap.put(firstMapEntry.getKey(), firstMapTemplate);
            }
        }

        return secondFirstMapMap;
    }

    /**
     * 将Map 根据另一个Map进行映射
     *
     * @param rawMap     需要映射到原始Map
     * @param reflectMap 映射基础，映射规则是 key：是最终结果Key；value：是raw的原始key
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> Map<U, Map<String, T>> reflectMap(Map<String, T> rawMap, Map<U, String> reflectMap) {

        return reflectMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> rawMap.entrySet().stream()
                                .filter(rawMapEntry -> rawMapEntry.getKey().equals(entry.getValue()))
                                .collect(Collectors.toMap(Map.Entry::getKey,
                                        Map.Entry::getValue))));
    }

    /**
     * 将Map 根据另一个Map进行映射
     *
     * @param rawMap     需要映射到原始Map
     * @param reflectMap 映射基础，映射规则是 key：是最终结果value；key：是raw的原始key
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> Map<U, Map<String, T>> reflectDirectMap(Map<String, T> rawMap, Map<String, U> reflectMap) {

        return reflectMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue,
                        entry -> rawMap.entrySet().stream()
                                .filter(rawMapEntry -> rawMapEntry.getKey().equals(entry.getKey()))
                                .collect(Collectors.toMap(Map.Entry::getKey,
                                        Map.Entry::getValue))));
    }

    


    public static void main(String[] args) {

        Map<String, Map<String, Double>> result = new HashMap<>();
        result.put("1", new HashMap<String, Double>() {{
            put("a", 1.0);
            put("b", 2.0);
        }});

        result = reverseMapLevel(result);

        System.out.println(result.toString());

    }

}
