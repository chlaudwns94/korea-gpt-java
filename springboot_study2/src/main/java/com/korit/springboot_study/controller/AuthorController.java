package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.books.ReqAddAuthorDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.books.Author;
import com.korit.springboot_study.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/api/books/authors")
    public ResponseEntity<SuccessResponseDto<List<Author>>> getAuthors() {
        return ResponseEntity.ok().body(authorService.getAuthorAll());
    }

    @PostMapping("/api/books/author")
    public ResponseEntity<SuccessResponseDto<Author>> addAuthor(@Valid @RequestBody ReqAddAuthorDto reqAddAuthorDto) throws DuplicateKeyException {
        return ResponseEntity.ok().body(authorService.AddAuthor(reqAddAuthorDto));
    }
}
