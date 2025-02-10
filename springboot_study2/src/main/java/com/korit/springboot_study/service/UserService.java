package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqAddUserDto;
import com.korit.springboot_study.dto.request.ReqModifyUser;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.User;
import com.korit.springboot_study.entity.UserRole;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.repository.UserRepository;
import com.korit.springboot_study.repository.UserRoleRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Transactional(rollbackFor = Exception.class)
    public Boolean duplicateUsername (String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Transactional(rollbackFor = Exception.class)
    public User addUser(ReqAddUserDto reqAddUserDto) {
        User saveUser = userRepository.save(reqAddUserDto.toUser())
                .orElseThrow(
                        () -> new CustomDuplicateKeyException("", Map.of("username", "이미 사용중이 사용자이름 입니다.")));
        userRoleRepository.save(UserRole.builder()
                .userId(saveUser.getUserId())
                .roleId(1)
                .build()).orElseThrow(() -> new RuntimeException("SQL Error"));
        return saveUser;
    }

    @Transactional(rollbackFor = Exception.class)
    public User getUserById(int userId) throws NotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("해당 사용자 ID는 존재하지 않습니다"));
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<List<User>> findAllUsers() {
        return new SuccessResponseDto<>(userRepository.findAll());
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean modifyUser(int userId, ReqModifyUser reqModifyUser) throws NotFoundException {
        return userRepository.updateUserById(reqModifyUser.toUser(userId))
                .orElseThrow(() -> new NotFoundException("해당 사용자를 찾을수 없습니다."));
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteUser(int userId) throws NotFoundException {
        return userRepository.deleteById(userId)
                .orElseThrow(() -> new NotFoundException("해당 사용자 Id를 찾을수없습니다"));
    }
}
