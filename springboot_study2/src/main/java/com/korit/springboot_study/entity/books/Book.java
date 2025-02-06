package com.korit.springboot_study.entity.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private int bookId;
    private String bookName;
    private int authorId;
    private String isbn;
    private int categoryId;
    private int publisherId;
    private String url;
}
