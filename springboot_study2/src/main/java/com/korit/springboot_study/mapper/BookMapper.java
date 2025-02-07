package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.books.Book;
import com.korit.springboot_study.entity.books.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> selectAllBook();

    int insertBook(Book book);

    List<Book> selectAllBookByName(@Param(value = "bookName") String bookName);
}
