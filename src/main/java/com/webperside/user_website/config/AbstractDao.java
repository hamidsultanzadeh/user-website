package com.webperside.user_website.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDao {

    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/user_db";
        String username = "root";
        String password = "hamid318";
        return DriverManager.getConnection(url, username, password);
    }

}
