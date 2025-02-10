package com.korit.project.controller;

import com.korit.project.dto.request.ReqAddUserDto;
import com.korit.project.dto.response.common.ResponseDto;
import com.korit.project.dto.response.common.SuccessResponseDto;
import com.korit.project.entity.User;
import com.korit.project.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<SuccessResponseDto<User>> addUser(@Valid @RequestBody ReqAddUserDto reqAddUserDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(userService.addUser(reqAddUserDto)));
    }

    @GetMapping("/api/user/{userId}")
    @ApiOperation(value = "사용자 조회")
    public ResponseEntity<SuccessResponseDto<User>> getUser(
            @Min(value = 1, message = "사용자 ID는 1이상의 정수입니다.")
            @ApiParam(value = "사용자ID", example = "1", required = true)
            @PathVariable int userId) throws NotFoundException {

        return ResponseEntity.ok().body(new SuccessResponseDto<>(userService.getUserById(userId)));
    }
}
