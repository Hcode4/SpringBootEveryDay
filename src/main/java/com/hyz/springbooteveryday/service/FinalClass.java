package com.hyz.springbooteveryday.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author HYZ
 * @Created 2021/8/21
 */
@Slf4j
@Component
public class FinalClass {

    public final String sayHello() {
        log.info("Say Hello");
        return "Hello, Man!";
    }
}
