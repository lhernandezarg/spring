package com.prrin.service;


import com.prrin.model.Email;
import com.prrin.model.EmailAtached;

public interface IEmailService {

	int sendEmail(Email email) throws Exception;

	int sendEmailTemplate(Email email) throws Exception;

	int sendEmailAtachedFiles(EmailAtached email) throws Exception;

}
