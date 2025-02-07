package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.books.ReqAddBookDto;
import com.korit.springboot_study.dto.request.books.ReqSearchBookDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.books.Book;
import com.korit.springboot_study.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<List<Book>> getAllBooks() {
        List<Book> foundBooks = bookRepository.findAllBooks().orElseThrow();
        return new SuccessResponseDto<>(foundBooks);
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<Book> AddBooks(ReqAddBookDto reqAddBookDto) throws DuplicateKeyException {
        return new SuccessResponseDto<>(
                bookRepository.saveBooks(reqAddBookDto.toBook()).orElseThrow()
        );
    }

    public SuccessResponseDto<List<Book>> getAllBooksByName(ReqSearchBookDto reqSearchBookDto) {
        return new SuccessResponseDto<>(bookRepository.findBookByName(reqSearchBookDto.getBookName()).orElseThrow());
    }
}
