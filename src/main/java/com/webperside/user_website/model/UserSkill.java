package com.webperside.user_website.model;


public class UserSkill {

    private Integer userSkillId;
    private User user;
    private Skill skill;
    private Integer power;

    public UserSkill() {
    }

    public UserSkill(Integer userSkillId, User user, Skill skill, Integer power) {
        this.userSkillId = userSkillId;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }

    public Integer getUserSkillId() {
        return userSkillId;
    }

    public void setUserSkillId(Integer userSkillId) {
        this.userSkillId = userSkillId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
