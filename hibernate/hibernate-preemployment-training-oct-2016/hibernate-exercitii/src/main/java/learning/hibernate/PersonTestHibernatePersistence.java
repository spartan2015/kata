package learning.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Person;

public class PersonTestHibernatePersistence {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		try {
			Person person = new Person();
			person.setCnp("1");
			person.setName("John");

			// persist
			session.persist(person);

			person = (Person) session.get(Person.class, "1");

			Query query = session.createQuery("select p from Person per where per.name = :name");
			query.setString("name", "John");
			@SuppressWarnings("unchecked")
			List<Person> persons = query.list();

			// deletion
			// - you need to get a reference to the class first
			person = (Person) session.get(Person.class, "1");
			// then delete by calling remove
			if (person != null) {
				session.delete(person);
			}

			tx.commit();
		} catch (Exception ex) {
			try {
				tx.rollback();
			} catch (Exception ex1) {
				ex.printStackTrace();
			}
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
