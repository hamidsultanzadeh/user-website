package com.webperside.user_website.controller;

import com.webperside.user_website.config.Context;
import com.webperside.user_website.dao.inter.SkillDao;
import com.webperside.user_website.dao.inter.UserDao;
import com.webperside.user_website.dao.inter.UserSkillDao;
import com.webperside.user_website.model.Skill;
import com.webperside.user_website.model.User;
import com.webperside.user_website.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "UserAddController", urlPatterns = "/user-add")
public class UserAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SkillDao skillDao = Context.skillDaoInstance();
        List<Skill> skills = skillDao.findAll();
        req.setAttribute("skills", skills);
        req.getRequestDispatcher("user-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            UserDao dao = Context.userDaoInstance();
            SkillDao skillDao = Context.skillDaoInstance();
            UserSkillDao userSkillDao = Context.userSkillDaoInstance();

            System.out.println(Arrays.toString(req.getParameterValues("skillId[]")));
            System.out.println(Arrays.toString(req.getParameterValues("power[]")));

            String skillIdStr = req.getParameter("skillId");

            if (skillIdStr != null) {
                Integer skillId = Integer.parseInt(skillIdStr);
                if (skillDao.checkSkillExistsById(skillId)) {
                    User u = new User();

                    u.setName(req.getParameter("name"));
                    u.setSurname(req.getParameter("surname"));

                    int id = dao.save(u);

                    userSkillDao.saveUserSkill(id, skillId, 10);
                    resp.sendRedirect("users");
                } else{
                    throw new IllegalArgumentException("Skill not found");
                }
            } else {
                throw new IllegalArgumentException("Skill ID undefined");
            }


        } catch (Exception ex){
            ex.printStackTrace();
            ControllerUtil.redirectToError(resp, ex.getMessage());
        }
    }
}
