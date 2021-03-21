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
import java.util.List;

@WebServlet(name = "UsersController", urlPatterns = "/users")
public class UsersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        UserDao dao = Context.userDaoInstance();

        List<User> users = dao.findAll(name, surname);

        req.setAttribute("alma", users);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}
