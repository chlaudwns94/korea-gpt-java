package com.korit.project.service;

import com.korit.project.dto.request.ReqAddUserDto;
import com.korit.project.entity.User;
import com.korit.project.exception.CustomDuplicateKeyException;
import com.korit.project.repository.UserRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(ReqAddUserDto reqAddUserDto) {
        User saveUser = userRepository.save(reqAddUserDto.toUser())
                .orElseThrow(
                        () -> new CustomDuplicateKeyException("", Map.of("username", "이미 사용중인 사용자 이름입니다."))
                );
        return saveUser;
    }

    public User getUserById(int userId) throws NotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("해당 사용자 id 없다"));
    }

}
