package com.hyz.springbooteveryday.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author HYZ
 * @Created 2021/10/27
 */
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StreamFunctionTest {


    // function 对数据进行处理,并且有返回值
    Function<String, List<String>> strSplit = (str) -> Arrays.asList(str.split(","));

    // 对数据进行消费, 可以是对数据库的某些操作等
    Consumer<String> stringConsumer = log::info;

    // 对数据进行验证
    Predicate<String> stringPredicate = (str) -> str.equals("123");

    Supplier<String> stringGet = () -> "123";


    public void op(Function<String, List<String>> strSplit, String strString) {
        strSplit.apply(strString);
    }

    @Test
    public void functionTest() {
        List<String> result = strSplit.apply("123,234");
        log.info(String.valueOf(result));

        op(strSplit, "123,234");

        stringConsumer.accept("123");

        stringPredicate.test("123");

        log.info(stringGet.get());

    }

}
