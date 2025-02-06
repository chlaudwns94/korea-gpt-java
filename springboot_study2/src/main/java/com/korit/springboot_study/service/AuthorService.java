package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.books.ReqAddAuthorDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.books.Author;
import com.korit.springboot_study.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<List<Author>> getAuthorAll() {
        List<Author> foundAuthors = authorRepository.findAuthorAll().orElseThrow();
        return new SuccessResponseDto<>(foundAuthors);
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<Author> AddAuthor(ReqAddAuthorDto reqAddAuthorDto) throws DuplicateKeyException {
        return new SuccessResponseDto<>(
                authorRepository
                        .saveAuthor(new Author(0, reqAddAuthorDto.getAuthorName()))
                        .orElseThrow()
        );
    }
}
