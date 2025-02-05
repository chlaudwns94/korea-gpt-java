package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ReqAddStudentDto {
    @ApiModelProperty(value = "학생 이름", example = "OOO", required = true)
    private String name;
    @ApiModelProperty(value = "학생 이름", example = "22", required = true)
    private int age;
}
