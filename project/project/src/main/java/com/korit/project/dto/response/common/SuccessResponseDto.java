package com.korit.project.dto.response.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@ApiModel(description = "성공응답 DTO")
public class SuccessResponseDto<T> extends ResponseDto<T>{
    @ApiModelProperty(value = "Http 상태 코드", example = "200")
    private final int status;
    @ApiModelProperty(value = "응답 메세지", example = "요청이 성공적으로 처리 되었습니다.")
    private String message;

    public SuccessResponseDto(T data) {
        super(data);
        status = 200;
        message = "요청이 성공적으로 처리되었습니다.";
    }
}
