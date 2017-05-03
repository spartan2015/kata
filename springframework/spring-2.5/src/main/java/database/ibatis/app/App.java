package database.ibatis.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.beans.Motorist;
import database.ibatis.MotoristSpringIBatisDao;
import database.ibatis.MotoristSpringIBatisDaoSupport;

public class App {

	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("database/ibatis/ibatis-persistence.xml");
		
		MotoristSpringIBatisDao dao = (MotoristSpringIBatisDao)ctx.getBean("motoristSpringIBatisDao");
		
		Motorist motorist = new Motorist();
		motorist.setEmail("jelu");
		motorist.setPassword("jelu");
		motorist.setFirstName("jelu");
		motorist.setLastName("jelu");

		dao.saveMotorist(motorist);
		
		List<Motorist> list = dao.getMotorists();
		for(Motorist m : list){
			System.out.println(m.getEmail());
		}
		
		Motorist m1 = dao.getMotoristById(10);
		System.out.println(m1.getEmail());
		
		
		MotoristSpringIBatisDaoSupport dao2 = (MotoristSpringIBatisDaoSupport)ctx.getBean("motoristSpringIBatisDaoSupport");
		List<Motorist> list2 = dao2.getMotorists();
		for(Motorist m : list2){
			System.out.println(m.getEmail());
		}
	}

}
