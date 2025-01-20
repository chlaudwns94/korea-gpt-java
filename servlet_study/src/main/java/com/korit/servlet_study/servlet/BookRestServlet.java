package com.korit.servlet_study.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.entity.Author;
import com.korit.servlet_study.entity.Book;
import com.korit.servlet_study.entity.BookCategory;
import com.korit.servlet_study.entity.Publisher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/book")
public class BookRestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Author author = new Author(1, "테스트저자");
        Publisher publisher = new Publisher(1, "테스트출판사");
        BookCategory bookCategory = new BookCategory(1, "테스트카테고리");

        Book book = Book.builder()
                .bookId(1)
                .bookName("Book 1")
                .bookImgUrl("http")
                .authorId(author.getAuthorId())
                .publisherId(publisher.getPublisherId())
                .categoryId(bookCategory.getCategoryId())
                .author(author)
                .publisher(publisher)
                .bookCategory(bookCategory)
                .build();
        String jsonBook = objectMapper.writeValueAsString(book);



//        resp.setHeader("Access-Control-Allow-Origin", "*");
//        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
//        resp.setHeader("Access-Control-Allow-Credentials", "true");


        resp.setContentType("application/json");
        resp.getWriter().println(jsonBook);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
