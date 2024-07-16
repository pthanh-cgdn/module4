package com.codegyme.mail_configuration.repositories.impl;

import com.codegyme.mail_configuration.models.MailSetting;
import com.codegyme.mail_configuration.repositories.IMailSettingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailSettingRepository implements IMailSettingRepository {
    private static List<MailSetting> mailSettings = new ArrayList<>();
    @Override
    public void add(MailSetting mailSetting) {
        mailSettings.add(mailSetting);
    }
}
