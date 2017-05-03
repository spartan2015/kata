package email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;

public class SendMail {
	private JavaMailSender mailSender;
	private SimpleMailMessage mailMessage;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}


	public void sendEmailForVehicle(String to) {

		SimpleMailMessage message = new SimpleMailMessage(mailMessage);

		message.setTo(to);

		String text = message.getText();

		text = StringUtils.replace(text, "%STATE%", null);

		text = StringUtils.replace(text, "%PLATE%", null);

		message.setText(text);

		mailSender.send(message);
	}
}
