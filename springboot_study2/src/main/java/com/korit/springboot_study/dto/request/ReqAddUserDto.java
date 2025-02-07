package com.korit.springboot_study.dto.request;

import com.korit.springboot_study.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class ReqAddUserDto {
    @ApiModelProperty(value = "사용자 이름", example = "user1234",required = true)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{4,16}$", message = "첫 글자는 반드시 영문자여야 합니다.")
    private String username;
    @ApiModelProperty(value = "비밀번호", example = "User12345678!",required = true)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}|;:'\",.<>/?]).{8,20}$", message = "적어도 하나의 특수문자(!@#$%^&*()_+\\\\-=[]{}|;:'\",.<>/?)가 포함되어야 합니다.")
    private String password;
    @ApiModelProperty(value = "성명", example = "OOO",required = true)
    @Pattern(regexp = "^[가-힇]{1,}$", message = "한글 2자 이상만 입력가능합니다")
    private String name;
    @ApiModelProperty(value = "이메일", example = "user1234@.com",required = true)
    @Email(message = "이메일 형식으로 입력해야합니다.")
    private String email;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }
}
