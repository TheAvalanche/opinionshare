package lv.akurss.opinionshare.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpamService {

	private static final Logger log = LoggerFactory.getLogger(SpamService.class);
	
	@Autowired
	EmailService emailService;
	
	@Scheduled(cron = "0 */1 * * * MON-SAT")
	public void sendSpam() {
		emailService.sendMail("alexkartishev@gmail.com", "Testers are never right", "If testers are right, look at the subject");
	}
	
}
