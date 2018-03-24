package lv.akurss.opinionshare.service;

public interface EmailService {
	
	void sendMail(String to, String subject, String text);
	
}
