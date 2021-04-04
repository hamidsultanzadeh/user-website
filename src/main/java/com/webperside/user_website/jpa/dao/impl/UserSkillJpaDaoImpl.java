package com.webperside.user_website.jpa.dao.impl;

import com.webperside.user_website.jpa.dao.AbstractDao;
import com.webperside.user_website.jpa.dao.inter.UserSkillJpaDao;
import com.webperside.user_website.jpa.model.User;
import com.webperside.user_website.jpa.model.UserSkill;

import javax.persistence.EntityManager;
import java.util.List;

public class UserSkillJpaDaoImpl extends AbstractDao implements UserSkillJpaDao {

    @Override
    public List<UserSkill> getUserSkills(Integer userId) {
        EntityManager em = em();

        User user = em.find(User.class,userId);
        List<UserSkill> skills = user.getSkillList();

        close(em);

        return skills;
    }

    @Override
    public void saveUserSkill(UserSkill userSkill) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(userSkill);
        em.getTransaction().commit();

        close(em);
    }

    @Override
    public void saveUserSkillList(List<UserSkill> userSkills) {
        EntityManager em = em();
        em.getTransaction().begin();
        for(UserSkill us : userSkills){
            em.persist(us);
        }
        em.getTransaction().commit();

        close(em);
    }

}
