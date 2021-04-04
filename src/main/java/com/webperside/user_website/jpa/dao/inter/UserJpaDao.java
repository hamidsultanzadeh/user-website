package com.webperside.user_website.jpa.dao.inter;


import com.webperside.user_website.jpa.model.User;

import java.util.List;

public interface UserJpaDao {

    User findById(Integer userId);

    boolean checkUserExistsById(Integer userId);

    Integer save(User user);

    void update(User user);

    List<User> findAll(String name, String surname);

    List<User> findAllCriteriaBuilder(String name, String surname);

    void delete(Integer userId);

    boolean checkUserExistsByEmailAndPassword(String email, String password);

    User getUserByEmailAndPassword(String email, String password);

}
