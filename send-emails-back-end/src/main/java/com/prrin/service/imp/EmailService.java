package com.prrin.service.imp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.prrin.model.Email;
import com.prrin.model.EmailAtached;
import com.prrin.service.IEmailService;

@Service
public class EmailService implements IEmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Value("${spring.mail.username}")
	private String email_base;

	Logger logger = LoggerFactory.getLogger(EmailService.class);

	@Override
	public int sendEmail(Email email) throws Exception {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom(email_base);
			msg.setTo(email.getTo());

			msg.setSubject(email.getSubject());
			msg.setText(email.getContent());

			javaMailSender.send(msg);

			return 200;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int sendEmailTemplate(Email email) throws Exception {
		try {

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();
			
			context.setVariables(modelTemplateEngine(email.getContent(), email.getTo()));
			String html =  templateEngine.process("Email", context);
			
			context = new Context();

			helper.setFrom(email_base);
			helper.setTo(email.getTo());

			helper.setSubject(email.getSubject());
			helper.setText(html);

			javaMailSender.send(message);

			return 200;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int sendEmailAtachedFiles(EmailAtached email) throws Exception {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom(email_base);
			msg.setTo(email.getTo());

			msg.setSubject(email.getSubject());
			msg.setText(email.getContent());

			javaMailSender.send(msg);

			return 200;
		} catch (Exception e) {
			throw e;
		}
	}

	private HashMap<String, Object> modelTemplateEngine(String content, String email) throws IOException {
		HashMap<String, Object> model = new HashMap<>();
		model.put("content", content);
		model.put("email", email);
		return model;
	}
}