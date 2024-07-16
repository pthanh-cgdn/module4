package com.codegyme.simple_dictionary.repositories.impl;

import com.codegyme.simple_dictionary.repositories.IDicRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DicRepository implements IDicRepository {
    static private Map<String,String> dictionary = new HashMap<>();
    static{
        dictionary.put("hello","xin chao");
        dictionary.put("goodbye","tam biet");
        dictionary.put("love","yeu");
        dictionary.put("peace","hoa binh");
    }
    public String translate(String word) {
        if(dictionary.containsKey(word)) {
            return dictionary.get(word);
        }
        return "Sorry!Your word is not found";
    }
}
