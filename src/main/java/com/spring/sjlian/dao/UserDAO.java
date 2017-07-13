package com.spring.sjlian.dao;

import com.spring.sjlian.model.User;

import java.util.List;

/**
 * Created by lian on 17/7/12.
 */
public interface UserDAO extends SuperDAO<User> {
    void save(User user);
    boolean update(User user);
    boolean delete(int id);
    User findById(int id);
    List<User> findAll();
    User findByName(String name);
}
