package com.korit.springboot_security.mapper;

import com.korit.springboot_security.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);
    User selectByUserName(String userName);
    User selectById(int userId);

    List<User> selectAllUsers();

    int updateUserById(User user);

    int deleteById(int userId);
}
