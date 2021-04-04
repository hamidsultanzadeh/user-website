package com.webperside.user_website.jpa.dao.impl;

import com.webperside.user_website.jpa.dao.AbstractDao;
import com.webperside.user_website.jpa.dao.inter.UserJpaDao;
import com.webperside.user_website.jpa.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserJpaDaoImpl extends AbstractDao implements UserJpaDao {

    @Override
    public User findById(Integer userId) {
        EntityManager em = em();
        User user = em.find(User.class, userId);
        close(em);
        return user;
    }

    @Override
    public boolean checkUserExistsById(Integer userId) {
        return findById(userId) != null;
    }

    @Override
    public Integer save(User user) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        close(em);

        return user.getUserId();
    }

    @Override
    public void update(User user) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

        close(em);

    }

    @Override
    public List<User> findAll(String name, String surname) {
        StringBuilder jpql = new StringBuilder("select u from User u where 1=1 ");

        if(name != null && !name.trim().isEmpty()){
            jpql.append(" and u.name = :n");
        }

        if(surname != null && !surname.trim().isEmpty()){
            jpql.append(" and u.surname = :s");
        }

        EntityManager em = em();

        Query query = em.createQuery(jpql.toString());

        if(name != null && !name.trim().isEmpty()){
            query.setParameter("n",name);
        }

        if(surname != null && !surname.trim().isEmpty()){
            query.setParameter("s",surname);
        }

        List result = query.getResultList();

        close(em);

        return result;
    }

    @Override
    public List<User> findAllCriteriaBuilder(String name, String surname) {
        EntityManager em = em();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> from = cq.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        if(name != null && !name.trim().isEmpty()){
            predicates.add(cb.equal(from.get("name"), name));
        }

        if(surname != null && !surname.trim().isEmpty()){
            predicates.add(cb.equal(from.get("surname"), surname));

        }

        cq.where(predicates.toArray(new Predicate[0]));

        Query query = em.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public void delete(Integer userId) {
        EntityManager em = em();

        User user = em.find(User.class, userId);

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();

        close(em);
    }

    @Override
    public boolean checkUserExistsByEmailAndPassword(String email, String password) {
        String jpql = "select u from User u where u.email = :e and u.password = :p";
        EntityManager em = em();

        Query query = em.createQuery(jpql);
        List result = query.getResultList();

        close(em);

        return result.size() == 1;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        String jpql = "select u from User u where u.email = :e and u.password = :p";
        EntityManager em = em();

        Query query = em.createQuery(jpql);
        query.setParameter("e",email);
        query.setParameter("p",password);

        List result = query.getResultList();

//        User u = result.get(0);

        close(em);

        if(result.size() == 1){
            return (User) result.get(0);
        } else {
            return null;
        }
    }
}
