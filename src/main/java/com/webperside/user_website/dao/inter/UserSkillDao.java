package com.webperside.user_website.dao.inter;

import com.webperside.user_website.model.UserSkill;

import java.util.List;

public interface UserSkillDao {

    List<UserSkill> getUserSkills(Integer userId);
}
