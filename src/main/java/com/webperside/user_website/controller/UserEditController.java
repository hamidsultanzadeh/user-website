package com.webperside.user_website.controller;

import com.webperside.user_website.config.Context;
import com.webperside.user_website.config.ContextJpa;
import com.webperside.user_website.dao.inter.UserDao;
import com.webperside.user_website.jpa.dao.inter.UserJpaDao;
import com.webperside.user_website.jpa.model.User;
import com.webperside.user_website.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserEditController", urlPatterns = "/user-edit")
public class UserEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            String idStr = req.getParameter("id");

            if (idStr != null) {
                Integer id = Integer.parseInt(idStr);
//                UserDao dao = Context.userDaoInstance();
                UserJpaDao dao = ContextJpa.userDaoInstance();


                if (dao.checkUserExistsById(id)) {
                    User u = dao.findById(id);

                    req.setAttribute("user", u);

                    req.getRequestDispatcher("user-edit.jsp").forward(req, resp);
                } else {
                    throw new IllegalArgumentException("User not found");
                }
            } else {
                throw new IllegalArgumentException("User ID undefined");
            }
        } catch(Exception ex){
            ex.printStackTrace();
            ControllerUtil.redirectToError(resp, ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 1. checkUserExistsById
            // 2. update
//          UserDao dao = Context.userDaoInstance();
            UserJpaDao dao = ContextJpa.userDaoInstance();

            String action = req.getParameter("action");

            String userIdStr = req.getParameter("id");

            if (userIdStr != null) {

                Integer userId = Integer.parseInt(req.getParameter("id"));

                if (action.equals("delete")) {
                    dao.delete(userId);
                } else {
                    User u = new User();

                    u.setUserId(userId);
                    u.setName(req.getParameter("name"));
                    u.setSurname(req.getParameter("surname"));

                    dao.update(u);
                }

            } else {
                throw new IllegalArgumentException("User ID not defined");
            }

            resp.sendRedirect("users");
        } catch (Exception ex) {
            ex.printStackTrace();
            ControllerUtil.redirectToError(resp, ex.getMessage());
        }


    }
}
