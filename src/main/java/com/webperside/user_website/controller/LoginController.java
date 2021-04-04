package com.webperside.user_website.controller;

import com.webperside.user_website.config.ContextJpa;
import com.webperside.user_website.jpa.dao.inter.UserJpaDao;
import com.webperside.user_website.jpa.model.User;
import com.webperside.user_website.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            // email - parvinetibarli@gmail.com
            // password - 12345 => 1327jkdbfuo23hbdnfb23

            // email - parvinetibarli@gmail.com
            // user => parvinetibarli@gmail.com, 1327jkdbfuo23hbdnfb23
            // password - 12345 => 1327jkdbfuo23hbdnfb2211223

            // token  -> spring security -
            // jwt.io ->

            if(email != null && password != null){
//                UserDao dao = Context.userDaoInstance();
                UserJpaDao dao = ContextJpa.userDaoInstance();

                User loggedUser = dao.getUserByEmailAndPassword(email, password);

                if(loggedUser != null){
                    req.getSession().setAttribute("userLoggedIn",loggedUser);
                    resp.sendRedirect("users");
                } else{
                    throw new IllegalArgumentException("User not exist");
                }
            } else{
                throw new IllegalArgumentException("Email or password invalid");
            }

        }catch (Exception ex){
            ex.printStackTrace();
            ControllerUtil.redirectToError(resp, ex.getMessage());
        }
    }
}
