package com.korit.springboot_study.dto.response.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "성공응답 DTO")
public class NotFoundResponseDto<T> extends ResponseDto<T> {
    @ApiModelProperty(value = "Http 상태 코드", example = "404")
    private final int status;
    @ApiModelProperty(value = "응답 메세지", example = "데이터를 찾을수 없습니다.")
    private String message;

    public NotFoundResponseDto(T data) {
        super(data);
        status = 404;
        message = "데이터를 찾을수 없습니다.";
    }
}
