package learning.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.Passport;
import entities.Person;

public class PersonTest {

	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction tx;
	private Long lastSaveId = null;

	@BeforeClass
	public static void  setup() {
		entityManagerFactory = Persistence.createEntityManagerFactory("helloworld");
	}

	@AfterClass
	public static void shutdown() {
		entityManagerFactory.close();
	}
	
	@Before
	public void before(){
		entityManager = entityManagerFactory.createEntityManager();
		tx = entityManager.getTransaction();
		tx.begin();
	}
	@After
	public void after(){
		tx.commit();
		entityManager.close();
	}

	@Test
	public void savePerson() {
		
		Person person = new Person();
		person.setName("John");

		entityManager.persist(person);
		
		lastSaveId = person.getId();

	}

	@Test
	public void getPerson() {

		Person person = entityManager.find(Person.class, lastSaveId);

		assertNotNull(person);

	}
	
	@Test
	public void queryPerson() {	
		Query query = entityManager.createQuery("select p from Person p where p.name = ?");
		query.setParameter(1, "John");
		List<Person> persons = query.getResultList();

		assertTrue(persons.size() == 1);	
	}

	@Test
	public void deletePerson() {
		
		Person person = entityManager.find(Person.class, lastSaveId);
		if (person != null) {
			entityManager.remove(person);
		}
	}

	@Test
	public void ide(){
		Person person = new Person();
		person.setName("John");

		entityManager.persist(person);
		
		Passport passport = new Passport();
		person.setIds(new HashSet(Arrays.asList(passport)));
		
		passport.setOwner(person);
		entityManager.persist(passport);
		
		entityManager.remove(passport);
	}
}


