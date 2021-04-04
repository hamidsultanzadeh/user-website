package com.webperside.user_website.config;

import com.webperside.user_website.jpa.dao.impl.SkillJpaDaoImpl;
import com.webperside.user_website.jpa.dao.impl.UserJpaDaoImpl;
import com.webperside.user_website.jpa.dao.impl.UserSkillJpaDaoImpl;
import com.webperside.user_website.jpa.dao.inter.SkillJpaDao;
import com.webperside.user_website.jpa.dao.inter.UserJpaDao;
import com.webperside.user_website.jpa.dao.inter.UserSkillJpaDao;

public class ContextJpa {

    public static UserJpaDao userDaoInstance(){
        return new UserJpaDaoImpl();
    }

    public static SkillJpaDao skillDaoInstance(){
        return new SkillJpaDaoImpl();
    }

    public static UserSkillJpaDao userSkillDaoInstance(){return new UserSkillJpaDaoImpl();}
}
