package com.codegyme.product_management.repositories.impl;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class BaseRepository {

    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }
}
