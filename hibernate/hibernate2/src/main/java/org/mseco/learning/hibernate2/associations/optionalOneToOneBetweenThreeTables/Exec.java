package org.mseco.learning.hibernate2.associations.optionalOneToOneBetweenThreeTables;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {
	public static void main(String[] args) {
		try{
		Session session = HibernateUtil
				.getSessionFactory(
						"org/mseco/learning/hibernate2/associations/optionalOneToOneBetweenThreeTables/hibernate.cfg.xml",true)
				.openSession();
		Transaction tx = session.beginTransaction();

		Person person = new Person();
		Desk desk = new Desk();
		Assignment assignment = new Assignment();

		assignment.setPerson(person);
		person.setAssignment(assignment);

		assignment.setDesk(desk);
		desk.setAssignment(assignment);


		
		person.setDesk(desk);
		desk.setPerson(person);
		
		
		session.save(person);
		session.save(desk);
		session.save(assignment);
		
		
		tx.commit();
		session.close();
		
		} finally{
			HibernateUtil.shutdown();
		}
		
	}
}
