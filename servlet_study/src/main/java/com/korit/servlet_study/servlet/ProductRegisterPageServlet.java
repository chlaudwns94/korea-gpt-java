package com.korit.servlet_study.servlet;

import com.korit.servlet_study.datas.DataList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.Charset;

// http://localhost:8080/servlet_study/product/register (Get)
@WebServlet("/product/register")
public class ProductRegisterPageServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("serverName","서블릿 학습");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("상품등록 페이지 doget 호출");
        HttpSession session = req.getSession();
        session.setAttribute("username", "junil");


        req.setAttribute("categories", DataList.getCategoryList());
        req.getRequestDispatcher("/WEB-INF/product_register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("category"));
        System.out.println(req.getParameter("productName"));
        System.out.println(req.getParameter("price"));
        System.out.println(req.getParameter("registerDate"));
        resp.setContentType("apllication/json");
        resp.setStatus(200);
        resp.getWriter().println("{\"name\":\"김준일\"}");
//        resp.getWriter().println("<script>"
//                + "alert(\"등록이 완료되었습니다.\");"
//                + "location.href=`http://localhost:8080/servlet_study_war//product/register`;"
//                + "</script>");
    }
}
