package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.books.ReqAddCategoryDto;
import com.korit.springboot_study.dto.request.books.ReqSearchCategoryDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.books.Category;
import com.korit.springboot_study.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("api/books/categoris")
    public ResponseEntity<SuccessResponseDto<List<Category>>> findAllCategories() {
        return ResponseEntity.ok().body(categoryService.findAllCategorys());
    }

    @PostMapping("api/books/category/add")
    public ResponseEntity<SuccessResponseDto<Category>> findCategoryById(@Valid @RequestBody ReqAddCategoryDto reqAddCategoryDto) throws DuplicateKeyException {
        return ResponseEntity.ok().body(categoryService.AddCategory(reqAddCategoryDto));
    }

    @GetMapping("api/books/category")
    public ResponseEntity<SuccessResponseDto<List<Category>>> findAllCategoriesByKeyword(@ModelAttribute ReqSearchCategoryDto reqSearchCategoryDto) throws Exception{
        return ResponseEntity.ok().body(categoryService.getCategories(reqSearchCategoryDto));
    }
}
