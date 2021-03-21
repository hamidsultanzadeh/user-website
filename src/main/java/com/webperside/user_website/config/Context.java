package com.webperside.user_website.config;


import com.webperside.user_website.dao.impl.UserDaoImpl;
import com.webperside.user_website.dao.inter.UserDao;

public class Context {

    public static UserDao userDaoInstance(){
        return new UserDaoImpl();
    }
}
