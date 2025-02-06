package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.books.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> selectAllBook();

    int insertBook(Book book);
}
