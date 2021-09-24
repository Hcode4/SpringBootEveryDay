package com.hyz.springbooteveryday.dao;

import com.hyz.springbooteveryday.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author HYZ
 * @Created 2021/8/29
 */
@Mapper
public interface UserDAO {

    @Select("Select * from `student`")
    List<UserDO> studentAll();

}
