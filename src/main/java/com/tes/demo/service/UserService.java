package com.tes.demo.service;

import com.tes.demo.dao.UserRepository;
import com.tes.demo.model.User;

import java.util.List;

public interface UserService {
    /**
     * save or update an user
     * @param user
     * @return saved user
     */
    User save(User user);

    /**
     * Get list of all users
     * @return users list
     */
    List<User> findAll();

    /**
     * Delete an user by Id
     * @param id
     */
    void deleteUser(Long id);
}
