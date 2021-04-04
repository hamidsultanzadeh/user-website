package com.webperside.user_website.jpa.dao.impl;

import com.webperside.user_website.jpa.dao.AbstractDao;
import com.webperside.user_website.jpa.dao.inter.SkillJpaDao;
import com.webperside.user_website.jpa.model.Skill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillJpaDaoImpl extends AbstractDao implements SkillJpaDao {

    @Override
    public List<Skill> findAll() {
        // JPQL  -> select s from Skill s
        // MySQL -> select * from skill
        String jpql = "select s from Skill s";

        EntityManager em = em();
        Query query = em.createQuery(jpql);

        return query.getResultList();
    }

    @Override
    public Skill getSkillById(Integer skillId) {
        EntityManager em = em();
        return em.find(Skill.class,skillId);
    }

    @Override
    public boolean checkSkillExistsById(Integer skillId) {
        EntityManager em = em();
        return em.find(Skill.class,skillId) != null;
    }
}
