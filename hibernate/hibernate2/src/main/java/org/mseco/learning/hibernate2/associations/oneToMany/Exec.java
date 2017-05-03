package org.mseco.learning.hibernate2.associations.oneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory("org/mseco/learning/hibernate2/associations/oneToMany/hibernate.cfg.xml").openSession();
		Transaction tx = session.beginTransaction();
		
		Person person = new Person();		
		Address address = new Address();
		person.getAddresses().add(address);
		address.setPerson(person);
		
		session.persist(person);
		
		tx.commit();
		session.close();

	}

}
