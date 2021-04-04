package com.webperside.user_website.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDao {

    private static EntityManagerFactory emf = null;

    public static EntityManager em() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("user-db-jpa");
        }
        return emf.createEntityManager();
    }

    public static void close(EntityManager em){
        em.close();
    }
}
