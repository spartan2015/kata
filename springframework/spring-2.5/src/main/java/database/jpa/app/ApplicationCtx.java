package database.jpa.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.beans.Motorist;
import database.jpa.MotoristJpaDao;

public class ApplicationCtx {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"database/jpa/jpa-persistence.xml");
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(
//		"database/jpa/jpa-springcontainer-persistence.xml");

		MotoristJpaDao motoristJpaDao = (MotoristJpaDao) ctx
				.getBean("motoristJpaDao");

		Motorist motorist = new Motorist();
		motorist.setEmail("irimia.vasile@gmail.com");
		motorist.setPassword("secreta bre");
		motorist.setFirstName("Vasile");
		motorist.setLastName("Irimia");

		motoristJpaDao.saveMotorist(motorist);

		List<Motorist> motorists = motoristJpaDao.getMotorists();
		for (Motorist m : motorists) {
			System.out.println(m.getEmail());
		}
	}
}
