package learning.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Person;

public class PersonTestJavaPersistence {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("helloworld");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
		try {

			Person person = new Person();
			person.setCnp("1");
			person.setName("John");

			tx.begin();
			// persist
			entityManager.persist(person);
			tx.commit();

			person = entityManager.find(Person.class, "1");

			Query query = entityManager.createQuery("select p from Person p where p.cnp = ?");
			query.setParameter(1, "1");
			@SuppressWarnings("unchecked")
			List<Person> persons = query.getResultList();

			// deletion
			// - you need to get a reference to the class first
			person = entityManager.find(Person.class, "1");
			// then delete by calling remove
			if (person != null) {
				entityManager.remove(person);
			}

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}
}
