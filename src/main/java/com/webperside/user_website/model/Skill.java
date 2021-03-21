package com.webperside.user_website.model;

public class Skill {

    private Integer skillId;
    private String name;

    public Skill() {
    }

    public Skill(Integer skillId, String name) {
        this.skillId = skillId;
        this.name = name;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
