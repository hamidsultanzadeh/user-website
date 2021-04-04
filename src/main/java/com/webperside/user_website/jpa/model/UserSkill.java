package com.webperside.user_website.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "user_skill")
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_skill_id")
    private Integer userSkillId;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_skill_id", referencedColumnName = "skill_id")
    private Skill skill;

    @Column(name = "power")
    private Integer power;

    public UserSkill() {
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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
