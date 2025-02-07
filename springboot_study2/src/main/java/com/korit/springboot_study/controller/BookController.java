package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.books.ReqAddBookDto;
import com.korit.springboot_study.dto.request.books.ReqSearchBookDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.books.Book;
import com.korit.springboot_study.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books/books")
    public ResponseEntity<SuccessResponseDto<List<Book>>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @PostMapping("/api/books/book/add")
    public ResponseEntity<SuccessResponseDto<Book>> addBook(@Valid @RequestBody ReqAddBookDto reqAddBookDto) throws DuplicateKeyException {
        return ResponseEntity.ok().body(bookService.AddBooks(reqAddBookDto));
    }

    @GetMapping("api/books/book")
    public ResponseEntity<SuccessResponseDto<List<Book>>> getAllBooksByName(@ModelAttribute ReqSearchBookDto reqSearchBookDto) {
        return ResponseEntity.ok().body(bookService.getAllBooksByName(reqSearchBookDto));
    }
}
