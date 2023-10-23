package com.leiou.mapper;

import com.leiou.pojo.User;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();
}
