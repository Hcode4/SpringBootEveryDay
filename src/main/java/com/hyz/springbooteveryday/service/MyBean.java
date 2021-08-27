package com.hyz.springbooteveryday.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author HYZ
 * @Created 2021/8/21
 */
@Component
public class MyBean {

    @Resource
    private FinalClass finalClass;


    public String sayHello() {
        return finalClass.sayHello();
    }



}
