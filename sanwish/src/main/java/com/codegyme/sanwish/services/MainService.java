package com.codegyme.sanwish.services;

import com.codegyme.sanwish.models.Order;
import com.codegyme.sanwish.repositories.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MainService {



    @Autowired
    private MainRepository mainRepository;
    public void save(String[] condiments) {
        mainRepository.save(condiments);
    }

    public List<Order> getAll() {
        return mainRepository.getAll();
    }
}
