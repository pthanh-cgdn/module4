package com.codegyme.registration_form.services.impl;

import com.codegyme.registration_form.models.User;
import com.codegyme.registration_form.repositories.IUserRepository;
import com.codegyme.registration_form.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
