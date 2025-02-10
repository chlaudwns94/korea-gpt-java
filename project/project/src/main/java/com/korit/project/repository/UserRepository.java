package com.korit.project.repository;

import com.korit.project.entity.User;
import com.korit.project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public Optional<User> save(User user) {
        try {
            userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    public Optional<User> findById(int id) {
       return Optional.ofNullable(userMapper.selectById(id));

    }

}
