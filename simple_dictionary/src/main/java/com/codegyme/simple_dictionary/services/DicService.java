package com.codegyme.simple_dictionary.services;

import com.codegyme.simple_dictionary.repositories.DicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicService {
    @Autowired
    private DicRepository dicRepository;
    public String translate(String word) {
        return dicRepository.translate(word);
    }
}
