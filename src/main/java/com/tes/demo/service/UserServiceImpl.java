package com.tes.demo.service;

import com.tes.demo.dao.UserRepository;
import com.tes.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public User save(User user){
        return this.userRepository.save(user);
    }
}
