package com.korit.springboot_study.dto.request.books;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqAddPublisherDto {
    @ApiModelProperty(value = "출판사명", required = true)
    @Pattern(regexp = "^[a-zA-Z가-힣\\s]+$", message = "특수문자는 포함되면안됩니다.")
    private String publisherName;
}
