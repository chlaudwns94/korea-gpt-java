package com.korit.boardback.repository;

import com.korit.boardback.entity.User;
import com.korit.boardback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper usermapper;

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(usermapper.selectByUsername(username));
    }

    public User save(User user) {
        usermapper.insert(user);
        return user;
    }
}
