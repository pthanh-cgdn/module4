package com.codegyme.mail_configuration.controllers;

import com.codegyme.mail_configuration.models.MailSetting;
import com.codegyme.mail_configuration.services.IMailSettingService;
import com.codegyme.mail_configuration.services.impl.MailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailSettingController {
    @Autowired
    private IMailSettingService mailSettingService;

    @GetMapping("/setting")
    public String setting(Model model) {
        model.addAttribute("mailSetting", new MailSetting());
        model.addAttribute("languageArray", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pagesArray", new int[]{5, 10, 15, 25, 50, 100});
        return "setting";
    }
    @PostMapping("/setting")
    public String save(@ModelAttribute MailSetting mailSetting, Model model) {
        mailSettingService.add(mailSetting);
        model.addAttribute("mailSetting", new MailSetting());
        model.addAttribute("msg","New setting is successfully saved");
        return "setting";
    }
}
