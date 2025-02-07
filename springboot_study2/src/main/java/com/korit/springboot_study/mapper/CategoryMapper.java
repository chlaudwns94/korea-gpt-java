package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.books.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category> selectAllCategory();

    int insertCategory(Category category);

    List<Category> selectAllCategoryByName(@Param(value = "categoryName") String categoryName);
}
