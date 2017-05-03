package database.jpa.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.beans.Motorist;
import database.jpa.MotoristJpaDaoSupport;

public class ApplicationCtxSpringContainerConfOnly {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"database/jpa/jpa-springcontainer-persistence.xml");

		MotoristJpaDaoSupport motoristJpaDaoSupport = (MotoristJpaDaoSupport) ctx
				.getBean("motoristJpaDaoSupport");

		Motorist motorist = new Motorist();
		motorist.setEmail("irimia.vasile@gmail.com");
		motorist.setPassword("secreta bre");
		motorist.setFirstName("Vasile");
		motorist.setLastName("Irimia");

		motoristJpaDaoSupport.saveMotorist(motorist);

		List<Motorist> motorists = motoristJpaDaoSupport.getMotorists();
		for (Motorist m : motorists) {
			System.out.println(m.getEmail());
		}
	}
}
