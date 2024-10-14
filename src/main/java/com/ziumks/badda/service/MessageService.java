package com.ziumks.badda.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@RequiredArgsConstructor
@Service("messageService")
public class MessageService {

    private final MessageSource messageSource;

    public String get200() {
        return getMessage("common.ok.200");
    }

    public String get500() {
        return getMessage("common.error.500");
    }

    public String get404() {
        return getMessage("common.error.404");
    }

    public String getNoRows() {
        return getMessage("common.error.rows");
    }

    public String getMessage(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }

    public String getMessage(String code) {
        return getMessage(code, null, LocaleContextHolder.getLocale());
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, LocaleContextHolder.getLocale());
    }



}
