package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqUpdateMajorDto {
    @ApiModelProperty(value = "학과명" , example = "컴퓨터공학과",required = true)
    @Pattern(regexp = "^[가-힣]+$", message = "문자열은 한글 문자만 포함해야 합니다. (한글이 아닌 문자가 포함되면 유효하지 않음)")
    private String majorName;
}
