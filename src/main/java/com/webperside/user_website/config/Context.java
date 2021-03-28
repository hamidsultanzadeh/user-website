package com.webperside.user_website.config;


import com.webperside.user_website.dao.impl.SkillDaoImpl;
import com.webperside.user_website.dao.impl.UserDaoImpl;
import com.webperside.user_website.dao.impl.UserSkillDaoImpl;
import com.webperside.user_website.dao.inter.SkillDao;
import com.webperside.user_website.dao.inter.UserDao;
import com.webperside.user_website.dao.inter.UserSkillDao;

public class Context {

    public static UserDao userDaoInstance(){
        return new UserDaoImpl();
    }

    public static SkillDao skillDaoInstance(){
        return new SkillDaoImpl();
    }

    public static UserSkillDao userSkillDaoInstance(){return new UserSkillDaoImpl();}
}
