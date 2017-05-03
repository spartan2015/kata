package learning.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Address;
import entities.Bus;
import entities.NationalId;
import entities.Passport;
import entities.Person;
import entities.Pet;
import entities.Truck;

public class PersonTestJavaPersistence {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("helloworld");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();

		Person person = new Person();
		person.setCnp("1");
		person.setName("John");

		
		
		tx.begin();
		// persist
		entityManager.persist(person);
		
		
		Address address = new Address();
		person.setAddress(address);
		
		Pet pet = new Pet();
		pet.setName("Bubu");		
		pet.setOwner(person);
		entityManager.persist(pet);
		
		//optional
		//person.setPets(new HashSet(Arrays.asList(pet)));
		
		Passport passport = new Passport();
		passport.setId("001");
		passport.setCreationDate(new Date());
		passport.setNumber("123");
		passport.setOwner(person);
		
		entityManager.persist(passport);
		
		NationalId nationalId = new NationalId();
		nationalId.setOwner(person);
		nationalId.setId("002");
		
		entityManager.persist(nationalId);
	
		Bus bus = new Bus();
		bus.setNumber("CJ-04-TUV");
		entityManager.persist(bus);
		
		Truck truck = new Truck();
		truck.setNumber("CJ-02-TRK");
		entityManager.persist(truck);
		
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

		entityManager.close();

		entityManagerFactory.close();

	}
}
