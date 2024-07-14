package com.codegyme.money_exchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class MainController {
    @GetMapping("/exchange")
    public String exchange() {
        return "exchange";
    }
    @PostMapping("/result")
    public String displayResult(@RequestParam("amount") int amount,@RequestParam("currency") String currency, Model model) {
        if(currency.equals("usd")) {
            model.addAttribute("amount", amount*25000);
            model.addAttribute("currency", "vnd");
        } else {
            model.addAttribute("amount", amount/25000);
            model.addAttribute("currency", "usd");
        }
        return "result";
    }
}
