package com.vti.config.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

@Component
@Scope("prototype")
public class messageProperties{

	@Autowired
	private MessageSource messageSource;

	public String GetMessage(String key) {
		return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}

	public String GetMessage(String key, String defaultValue) {
		return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}
	
}
