package com.hyz.springbooteveryday.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author HYZ
 * @Created 2021/9/5
 */
@Setter
@Getter
@ToString
public class UserDO {
    private int id;
    private String name;
    private int age;
    private Integer sex;

}