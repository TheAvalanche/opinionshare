package lv.akurss.opinionshare.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"test", "dev"})
public class EmailServiceMock implements EmailService {

	private static final Logger log = LoggerFactory.getLogger(EmailServiceMock.class);
	
	@Override
	public void sendMail(String to, String subject, String text) {
		log.info("Sengin mock mail to {}; with subject {}; with body {}", to, subject, text);
	}
}
