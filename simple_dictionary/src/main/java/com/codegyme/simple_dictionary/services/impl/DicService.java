package com.codegyme.simple_dictionary.services.impl;

import com.codegyme.simple_dictionary.repositories.IDicRepository;
import com.codegyme.simple_dictionary.repositories.impl.DicRepository;
import com.codegyme.simple_dictionary.services.IDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicService implements IDicService {
    @Autowired
    private IDicRepository dicRepository;
    public String translate(String word) {
        return dicRepository.translate(word);
    }
}
