package com.webperside.user_website.jpa.dao.inter;

import com.webperside.user_website.jpa.model.Skill;

import java.util.List;

public interface SkillJpaDao {

    List<Skill> findAll();

    Skill getSkillById(Integer skillId);

    boolean checkSkillExistsById(Integer skillId);
}
