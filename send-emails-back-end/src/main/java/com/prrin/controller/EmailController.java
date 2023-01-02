package com.prrin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.prrin.controller.response.ResponseSuccess;
import com.prrin.model.Email;
import com.prrin.service.IEmailService;

@RestController
@RequestMapping("/api/v1/send-email")
public class EmailController {

	@Autowired
	private IEmailService service;

	@PostMapping("/")
	public ResponseEntity<?> sendEmail(@RequestBody Email email) throws Exception {
		service.sendEmail(email);
		return new ResponseEntity<ResponseSuccess>(new ResponseSuccess("Email Sended"), HttpStatus.OK);
	}

	@PostMapping("/email-whit-format")
	public ResponseEntity<?> sendTemplateEmail(@RequestBody Email email) throws Exception {
		service.sendEmailTemplate(email);
		return new ResponseEntity<ResponseSuccess>(new ResponseSuccess("Email whit Format Sended"), HttpStatus.OK);
	}

//	@PostMapping(value = "/email-atached-file", consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.MULTIPART_FORM_DATA_VALUE })
//	public ResponseEntity<?> sendEmailAtached(@RequestPart("email") String email,
//			@RequestParam("file") MultipartFile file) throws Exception {
////		service.sendEmailAtachedFiles(
////				new EmailAtached(email.getTo(), email.getCc(), email.getSubject(), email.getContent(), file));
//		return new ResponseEntity<ResponseSuccess>(new ResponseSuccess("Email Atached File Sended"), HttpStatus.OK);
//	}
}
