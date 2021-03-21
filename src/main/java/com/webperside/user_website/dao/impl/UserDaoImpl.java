package com.webperside.user_website.dao.impl;

import com.webperside.user_website.config.AbstractDao;
import com.webperside.user_website.dao.inter.UserDao;
import com.webperside.user_website.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("user_id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        return new User(id, name, surname);
    }

    @Override
    public User findById(Integer userId) {
        User result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from user where user_id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean checkUserExistsById(Integer userId) {
        try(Connection c = connect()){
            String sql = "select u.user_id from user u where u.user_id =" + userId;
            Statement stmt = c.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            if(rs.next()){
                System.out.println("i am here");
                System.out.println("USER ID " + rs.getInt("user_id"));
                return true;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void save(User user) {
        try {
            Connection c = connect();

            String sql = "insert into user(name, surname) " +
                    "values(?,?)";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());

            ps.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            Connection c = connect();
            String sql = "update user set name = ?, surname = ? " +
                    "where user_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getUserId());

            ps.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public List<User> findAll(String name, String surname) {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            StringBuilder sqlBuilder = new StringBuilder("select * from user u where 1=1");

            if(name != null && !name.trim().isEmpty()){
                sqlBuilder.append(" and name = ?");
            }

            if(surname != null && !surname.trim().isEmpty()){
                sqlBuilder.append(" and surname = ?");
            }

            PreparedStatement ps = c.prepareStatement(sqlBuilder.toString());

            int count=1;
            if(name != null && !name.trim().isEmpty()){
                ps.setString(count++, name);
            }

            if(surname != null && !surname.trim().isEmpty()){
                ps.setString(count, surname);
            }

            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                result.add(getUser(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(Integer userId) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("delete from user where user_id = " + userId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
