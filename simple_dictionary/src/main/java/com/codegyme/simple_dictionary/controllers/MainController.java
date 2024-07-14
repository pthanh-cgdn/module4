package com.codegyme.simple_dictionary.controllers;

import com.codegyme.simple_dictionary.services.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    DicService dicService;

    @GetMapping("/dictionary")
    public String dictionary() {
        return "dictionary";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        model.addAttribute("word", dicService.translate(word.toLowerCase()));
        return "result";
    }
}
