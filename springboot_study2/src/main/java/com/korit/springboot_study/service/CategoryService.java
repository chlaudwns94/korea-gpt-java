package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.books.ReqAddCategoryDto;
import com.korit.springboot_study.dto.request.books.ReqAddPublisherDto;
import com.korit.springboot_study.dto.request.books.ReqSearchCategoryDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.books.Category;
import com.korit.springboot_study.repository.CategoryRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<List<Category>> findAllCategorys() {
        List<Category> foundCategory = categoryRepository.getAllCategory().orElseThrow();
        return new SuccessResponseDto<>(foundCategory);
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<Category> AddCategory(ReqAddCategoryDto reqAddCategoryDto) throws DuplicateKeyException {
        return new SuccessResponseDto<>(
                categoryRepository
                        .saveCategory(new Category(0, reqAddCategoryDto.getCategoryName()))
                        .orElseThrow()
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<List<Category>>  getCategories(ReqSearchCategoryDto reqSearchCategoryDto) throws Exception{
        List<Category> searchCategory = categoryRepository.getCategoryByName(reqSearchCategoryDto.getKeyword())
                .orElseThrow(() -> new NotFoundException("조회된 카테고리가 없습니다."));
        return new SuccessResponseDto<>(searchCategory);
    }



}
