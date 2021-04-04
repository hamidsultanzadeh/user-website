package com.webperside.user_website.controller;

import com.webperside.user_website.config.ContextJpa;
import com.webperside.user_website.jpa.dao.inter.SkillJpaDao;
import com.webperside.user_website.jpa.dao.inter.UserJpaDao;
import com.webperside.user_website.jpa.dao.inter.UserSkillJpaDao;
import com.webperside.user_website.jpa.model.Skill;
import com.webperside.user_website.jpa.model.User;
import com.webperside.user_website.jpa.model.UserSkill;
import com.webperside.user_website.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserAddController", urlPatterns = "/user-add")
public class UserAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        SkillDao skillDao = Context.skillDaoInstance();
        SkillJpaDao skillDao = ContextJpa.skillDaoInstance();
        List<Skill> skills = skillDao.findAll();
        req.setAttribute("skills", skills);
        req.getRequestDispatcher("user-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
//            UserDao dao = Context.userDaoInstance();
//            SkillDao skillDao = Context.skillDaoInstance();
//            UserSkillDao userSkillDao = Context.userSkillDaoInstance();

            UserJpaDao dao = ContextJpa.userDaoInstance();
            SkillJpaDao skillDao = ContextJpa.skillDaoInstance();
            UserSkillJpaDao userSkillDao = ContextJpa.userSkillDaoInstance();

            User u = new User();

            u.setName(req.getParameter("name"));
            u.setSurname(req.getParameter("surname"));
            u.setEmail(req.getParameter("email"));
            u.setPassword(req.getParameter("password"));

            int id = dao.save(u);

            String[] skillsId = req.getParameterValues("skillId[]");
            String[] powers = req.getParameterValues("power[]");
            List<Skill> skills = new ArrayList<>();
            List<UserSkill> userSkills = new ArrayList<>();

            if(skillsId != null){
                for(String skillId : skillsId){
                    Skill skill = skillDao.getSkillById(Integer.parseInt(skillId));
                    if(skill != null){
                        skills.add(skill);
                    }
                }
            }

            for(int i = 0 ; i < skills.size() ; i++){
                Skill skill = skills.get(i);
                UserSkill userSkill = new UserSkill();
                userSkill.setUser(u);
                userSkill.setSkill(skill);
                userSkill.setPower(Integer.parseInt(powers[i]));

                userSkills.add(userSkill);
            }

            userSkillDao.saveUserSkillList(userSkills);

            resp.sendRedirect("users.jsp");

        } catch (Exception ex){
            ex.printStackTrace();
            ControllerUtil.redirectToError(resp, ex.getMessage());
        }
    }
}
