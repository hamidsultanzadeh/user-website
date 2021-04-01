package com.webperside.user_website.jpa;

import com.webperside.user_website.jpa.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("user-db-jpa");
//        EntityManager em = emf.createEntityManager();
//
//        User user = em.find(User.class, 15);

//        User user = getById();
//
//        user.setName("hamid");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("user-db-jpa");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 15);

        try{
            em.getTransaction().begin();
            em.remove(user);
            em.remove(user);
            em.remove(user);
            em.remove(user); // update
            em.getTransaction().commit();
        } catch (Exception ex){
            em.getTransaction().rollback();
        }


//        User user = new User();
//        user.setName("hamid");
//        user.setSurname("sultanzadeh");
//        user.setEmail("hs@gmail.com");
//        user.setPassword("12345");
//
//        em.getTransaction().begin();
//        em.persist(user); // save
//        em.getTransaction().commit();

//        User user = em.find(User.class, 14);
//
//        System.out.println(user.getSkillList());
//
//        System.out.println(user.getEmail());
    }

    public static User getById(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("user-db-jpa");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 15);

        emf.close();
        em.close();
        return user;
    }
}
