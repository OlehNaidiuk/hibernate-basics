package com.naidiuk.hibernatebasics.repository;

import com.naidiuk.hibernatebasics.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Transactional
    public User update(User user) {
        return em.merge(user);
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void delete(Long id) {
        User user = findById(id);
        if(user == null) {
            throw new RuntimeException(String.format("User with id=%d not found!", id));
        } else {
            em.remove(user);
        }
    }

    public List<User> getAll() {
        Query selectAllUsers = em.createQuery("select u from User u");
        return selectAllUsers.getResultList();
    }
}
