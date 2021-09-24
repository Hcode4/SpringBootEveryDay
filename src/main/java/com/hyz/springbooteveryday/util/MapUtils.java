package com.hyz.springbooteveryday.util;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

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
