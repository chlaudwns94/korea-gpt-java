package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.books.Author;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {

    List<Author> selectAllAuthor();

    int insertAuthor(Author author);

}
