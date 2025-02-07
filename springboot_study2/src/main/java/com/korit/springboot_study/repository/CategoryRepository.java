package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.books.Category;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryMapper categoryMapper;

    public Optional<List<Category>> getAllCategory() {
        List<Category> foundCategory = categoryMapper.selectAllCategory();
        return categoryMapper.selectAllCategory()
                .isEmpty()
                ? Optional.empty()
                : Optional.of(foundCategory);
    }

    public Optional<Category> saveCategory(Category category) throws DuplicateKeyException {
        try {
            categoryMapper.insertCategory(category);
        }catch (DuplicateKeyException e){
            throw  new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("categoryName","이미 존재하는 카테고리입니다.")
            );
        }
        return Optional.ofNullable(category);
    }

    public Optional<List<Category>> getCategoryByName(String categoryName) {
        return categoryMapper.selectAllCategoryByName(categoryName)
                .isEmpty()
                ? Optional.empty()
                :Optional.of(categoryMapper.selectAllCategoryByName(categoryName));
    }
}
