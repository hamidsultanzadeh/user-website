package com.webperside.user_website.jpa.dao.inter;

import com.webperside.user_website.jpa.model.UserSkill;

import java.util.List;

public interface UserSkillJpaDao {

    List<UserSkill> getUserSkills(Integer userId);

    void saveUserSkill(UserSkill userSkill);

    void saveUserSkillList(List<UserSkill> userSkills);
}
