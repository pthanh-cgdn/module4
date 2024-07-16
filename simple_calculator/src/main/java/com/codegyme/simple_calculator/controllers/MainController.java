package com.codegyme.simple_calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }
    @PostMapping("/result")
    public String result(@RequestParam("fop") String fop, @RequestParam("sop") String sop, @RequestParam("operator") String operator, Model model) {
        double firstOp = Double.parseDouble(fop);
        double secondOp = Double.parseDouble(sop);
        double result = 0;
        String op="";
        String msg="";
        switch (operator) {
            case "add":
                result = firstOp + secondOp;
                op="+";
                break;
            case "ded":
                result = firstOp - secondOp;
                op="-";
                break;
            case "mul":
                result = firstOp * secondOp;
                op="x";
                break;
            case "div":
                if(secondOp == 0){
                    msg = "Could not devide to 0";
                }
                result = firstOp / secondOp;
                op = "/";
                break;
        }
        model.addAttribute("result", result);
        model.addAttribute("op", op);
        model.addAttribute("firstOp", firstOp);
        model.addAttribute("secondOp", secondOp);
        model.addAttribute("msg", msg);
        return "result";
    }
}
