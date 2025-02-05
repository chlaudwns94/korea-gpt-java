package com.korit.springboot_study.dto.response.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel( description = "학생장보 학습 응답 dto")
public class RespStudentDto {
    @ApiModelProperty(value = "학생 ID", example = "1")
    private int id;
    @ApiModelProperty(value = "학생 이름", example = "홀길")
    private String name;
    @ApiModelProperty(value = "학생 나이", example = "10")
    private int age;
}
