package com.webperside.user_website.jpa;

import com.webperside.user_website.jpa.dao.impl.SkillJpaDaoImpl;
import com.webperside.user_website.jpa.dao.impl.UserJpaDaoImpl;
import com.webperside.user_website.jpa.model.Skill;
import com.webperside.user_website.jpa.model.User;
import com.webperside.user_website.jpa.model.UserSkill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

//        SkillJpaDaoImpl skillDaoImpl = new SkillJpaDaoImpl();
//
//        Skill skill = skillDaoImpl.findAll().get(0);
//
////        System.out.println(skillDaoImpl.checkSkillExistsById(1));
//
        UserJpaDaoImpl daoImpl = new UserJpaDaoImpl();

        System.out.println(daoImpl.findAllCriteriaBuilder("Hamid", ""));
//
//        User user = new User();
//        user.setName("Hamid 22");
//        user.setPassword("hamid123");
//        user.setSurname("Sultanzadeh 22");
//        user.setEmail("hamid@gmail.com");
//
//        UserSkill userSkill = new UserSkill();
//        userSkill.setUser(user);
//        userSkill.setSkill(skill);
//        userSkill.setPower(18);
//
//        daoImpl.save(user);
    }
}
