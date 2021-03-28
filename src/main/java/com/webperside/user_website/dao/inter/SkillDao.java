package com.webperside.user_website.dao.inter;

import com.webperside.user_website.model.Skill;

import java.util.List;

public interface SkillDao {

    List<Skill> findAll();

    boolean checkSkillExistsById(Integer skillId);
}
