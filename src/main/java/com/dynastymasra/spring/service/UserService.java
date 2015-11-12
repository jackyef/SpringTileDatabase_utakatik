/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.User;
import java.util.List;

/**
 *
 * @author LabGSG
 */
public interface UserService {
    void save(User user);
    User update(Integer id, User user);
    void delete(User user);
    void delete(Integer id);
    List<User> findAll();
    User findById(Integer id);
    boolean validateLogin(String u, String p);
}
