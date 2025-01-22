package com.korit.servlet_study.dto;

import com.korit.servlet_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigninDto {
    private String username;
    private String password;

    public User toDto() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
