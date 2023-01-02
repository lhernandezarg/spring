package com.prrin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.prrin.controller.response.ResponseSuccess;
import com.prrin.model.Email;
import com.prrin.model.EmailAtached;
import com.prrin.service.IEmailService;

@Controller
@RequestMapping("/api/v1/send-email/email-atached-file")
public class EmailAttachedController {

	@Autowired
	private IEmailService service;

	@PostMapping
	public ResponseEntity<?> sendEmailAtached(@RequestParam("file") MultipartFile file,
			@RequestPart("email") Email email) throws Exception {
		service.sendEmailAtachedFiles(
				new EmailAtached(email.getTo(), email.getCc(), email.getSubject(), email.getContent(), file));
		return new ResponseEntity<ResponseSuccess>(new ResponseSuccess("Email Atached File Sended"), HttpStatus.OK);
	}
}