package com.codegyme.mail_configuration.repositories;

import com.codegyme.mail_configuration.models.MailSetting;

public interface IMailSettingRepository {
    void add(MailSetting mailSetting);
}
