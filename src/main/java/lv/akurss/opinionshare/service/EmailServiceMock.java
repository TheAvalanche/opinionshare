package lv.akurss.opinionshare.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceMock implements EmailService {

	private static final Logger log = LoggerFactory.getLogger(EmailServiceMock.class);
	
	@Override
	public void sendMail(String to, String subject, String text) {
		log.info("Sengin mock mail to {}; with subject {}; with body {}", to, subject, text);
	}
}
