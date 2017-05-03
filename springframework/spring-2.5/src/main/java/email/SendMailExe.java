package email;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendMailExe {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"email/email.xml");
		SendMail sendMail = (SendMail)ctx.getBean("sendMail");
		sendMail.sendEmailForVehicle("irimia.vasile@gmail.com");
	}
}
