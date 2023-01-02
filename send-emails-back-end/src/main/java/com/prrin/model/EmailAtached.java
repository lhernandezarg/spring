package com.prrin.model;

import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmailAtached extends Email {

	public EmailAtached() {
		super("", null, "", "");
	}

	private static final long serialVersionUID = 1L;
	private MultipartFile file;

	public EmailAtached(String to, String[] cc, String subject, String content) {
		super(to, cc, subject, content);
	}

	public EmailAtached(String to, String[] cc, String subject, String content, MultipartFile file) {
		super(to, cc, subject, content);
		this.file = file;
	}

}
