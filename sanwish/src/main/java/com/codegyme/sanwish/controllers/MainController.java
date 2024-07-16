package com.codegyme.sanwish.controllers;

import com.codegyme.sanwish.models.Order;
import com.codegyme.sanwish.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;
    @RequestMapping
    @GetMapping("/sandwich")
    public String displaySandwichCondiments(Model model) {
        List<Order> orders = mainService.getAll();
        model.addAttribute("orders", orders);
        return "sandwich/list";
    }
    @GetMapping("/sandwich/save")
    public String save(Model model) {
        return "sandwich/save";
    }
    @PostMapping("/sandwich/save")
    public String saveSandwichCondiments(@RequestParam("condiments") String[] condiments) {
        mainService.save(condiments);
        return "redirect:/sandwich";
    }
}
