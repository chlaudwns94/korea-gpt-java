package com.korit.servlet_study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(request, response);
    }
}
