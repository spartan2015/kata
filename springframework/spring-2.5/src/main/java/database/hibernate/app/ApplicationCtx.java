package database.hibernate.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.beans.Motorist;
import database.hibernate.MotoristHibernateDao;
import database.hibernate.MotoristHibernateDaoSupport;

public class ApplicationCtx {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"database/hibernate/hibernate-annotation-mapping-persistence.xml");

		MotoristHibernateDao motoristHibernateDao = (MotoristHibernateDao)ctx.getBean("motoristHibernateDao");
		
		Motorist motorist = new Motorist();
		motorist.setEmail("irimia.vasile@gmail.com");
		motorist.setPassword("secreta bre");
		motorist.setFirstName("Vasile");
		motorist.setLastName("Irimia");
		
		motoristHibernateDao.saveMotorist(motorist);
		
		List<Motorist> motorists = motoristHibernateDao.getMotorists();
		for(Motorist m : motorists){
			System.out.println(m.getEmail());
		}
		
		MotoristHibernateDaoSupport motoristHibernateDaoSupport = (MotoristHibernateDaoSupport)ctx.getBean("motoristHibernateDaoSupport");
		
		motorists = motoristHibernateDaoSupport.getMotorists();
		for(Motorist m : motorists){
			System.out.println(m.getEmail());
		}
		
	}

}
