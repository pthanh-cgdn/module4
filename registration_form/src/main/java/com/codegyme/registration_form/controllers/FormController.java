package com.codegyme.registration_form.controllers;

import com.codegyme.registration_form.dtos.UserDto;
import com.codegyme.registration_form.models.User;
import com.codegyme.registration_form.services.IUserService;
import com.codegyme.registration_form.services.impl.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "user")
public class FormController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String index(Model model, @RequestParam(name="username",defaultValue = "") String username) {
        model.addAttribute("users",userService.findAll());
        model.addAttribute("username", username);
        return "user/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("userDto") UserDto userDto,
                         BindingResult bindingResult, RedirectAttributes redirect, Model model) {
//        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/user";
    }
}
