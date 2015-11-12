package com.dynastymasra.spring.service.impl;

import com.dynastymasra.spring.domain.User;
import com.dynastymasra.spring.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */ 
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.persist(user); //insert user
    }

    @Override
    public User update(Integer id, User user) {
        User oldUser = findById(id);
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setId(user.getId());
        return entityManager.merge(oldUser);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(user);
    }

    @Override
    public void delete(Integer id) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(findById(id));
    }

    @Override
    public List<User> findAll() {
        List<User> result = entityManager.createQuery("SELECT m FROM User m ORDER BY m.nim", User.class).getResultList();
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }
    
    @Override
    public boolean validateLogin(String u, String p) {
        List<User> result = entityManager.createQuery("SELECT m FROM User m WHERE username ='"+u+"' AND password='"+p+"'").getResultList();
        return (result.size() > 0);
    }
}
