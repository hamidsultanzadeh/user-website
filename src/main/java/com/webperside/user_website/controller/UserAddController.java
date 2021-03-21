package com.webperside.user_website.controller;

import com.webperside.user_website.config.Context;
import com.webperside.user_website.dao.inter.UserDao;
import com.webperside.user_website.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserAddController", urlPatterns = "/user-add")
public class UserAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao dao = Context.userDaoInstance();

        User u = new User();

        u.setName(req.getParameter("name"));
        u.setSurname(req.getParameter("surname"));

        dao.save(u);

        resp.sendRedirect("users");
    }
}
