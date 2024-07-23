package com.codegyme.registration_form.repositories;

import com.codegyme.registration_form.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
