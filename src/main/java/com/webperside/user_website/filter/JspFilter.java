package com.webperside.user_website.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(displayName = "JspFilter", urlPatterns = "*.jsp")
public class JspFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if(!req.getRequestURI().contains("index")){
            resp.sendRedirect("error?msg=Page not found");
        } else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
