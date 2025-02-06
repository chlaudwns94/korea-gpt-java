package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.books.Author;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class AuthorRepository {

    @Autowired
    private AuthorMapper authorMapper;

    public Optional<List<Author>> findAuthorAll() {
        List<Author> foundAuthors = authorMapper.selectAllAuthor();

        return foundAuthors.isEmpty()
                ? Optional.empty()
                :Optional.ofNullable(foundAuthors);
    }

    public Optional<Author> saveAuthor(Author author) throws DuplicateKeyException {
        try {
            authorMapper.insertAuthor(author);
        }catch (DuplicateKeyException e){
            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("authorName", "이미 존재하는 저자명입니다.")
            );
        }
            return Optional.ofNullable(new Author(author.getAuthorId(), author.getAuthorName()));
    }
}
