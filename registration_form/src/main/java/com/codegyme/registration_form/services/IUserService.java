package com.codegyme.registration_form.services;

import com.codegyme.registration_form.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
