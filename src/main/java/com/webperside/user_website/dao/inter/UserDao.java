package com.webperside.user_website.dao.inter;


import com.webperside.user_website.model.User;

import java.util.List;

public interface UserDao {

    User findById(Integer userId);

    boolean checkUserExistsById(Integer userId);

    void save(User user);

    void update(User user);

    List<User> findAll(String name, String surname);

    void delete(Integer userId);

}
