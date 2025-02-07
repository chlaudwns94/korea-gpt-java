package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.books.Book;
import com.korit.springboot_study.entity.books.Publisher;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepository {

    @Autowired
    private BookMapper bookMapper;

    public Optional<List<Book>> findAllBooks() {
        List<Book> foundBooks = bookMapper.selectAllBook();

        return foundBooks.isEmpty()
                ? Optional.empty()
                : Optional.of(foundBooks);
    }

    public Optional<Book> saveBooks(Book book) throws DuplicateKeyException {
        try {
            bookMapper.insertBook(book);
        }catch (DuplicateKeyException e){
            throw  new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("bookName", "이미 존재하는 책제목입니다.")
            );
        }
        return Optional.ofNullable(book);
    }

    public Optional<List<Book>> findBookByName(String bookName) {
        List<Book> foundPublisher = bookMapper.selectAllBookByName(bookName);
        return foundPublisher
                .isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundPublisher);
    }
}