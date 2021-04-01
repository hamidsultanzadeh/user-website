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
}
