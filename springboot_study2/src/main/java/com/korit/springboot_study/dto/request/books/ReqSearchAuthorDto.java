package com.korit.springboot_study.dto.request.books;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqSearchAuthorDto {
    @ApiModelProperty(value = "저자명")
    private String authorName;
}
