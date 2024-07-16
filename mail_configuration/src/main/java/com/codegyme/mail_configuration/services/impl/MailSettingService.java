package com.codegyme.mail_configuration.services.impl;

import com.codegyme.mail_configuration.models.MailSetting;
import com.codegyme.mail_configuration.repositories.IMailSettingRepository;
import com.codegyme.mail_configuration.services.IMailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSettingService implements IMailSettingService {
    @Autowired
    private IMailSettingRepository mailSettingRepository;
    @Override
    public void add(MailSetting mailSetting) {
        mailSettingRepository.add(mailSetting);
    }
}
