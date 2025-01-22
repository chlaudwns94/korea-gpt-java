package com.korit.servlet_study.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/api/test")
public class TestServlet extends HttpServlet {
    private AuthService authService;
    public TestServlet() {
        authService = AuthService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
            builder.append(line);
            }
        }

        ObjectMapper mapper = new ObjectMapper();



    }
}
