package com.codegyme.mail_configuration.models;

public class MailSetting {
    private String language;
    private String pageSize;
    private boolean SpamFilter;
    private String signature;

    public MailSetting() {
    }

    public MailSetting(String language, String pageSize, boolean isSpamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.SpamFilter = isSpamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getSpamFilter() {
        return SpamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        SpamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
