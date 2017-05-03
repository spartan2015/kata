package learning.hibernate;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import entities.Person;

public class PersonTestJdbc {

	@Test
	public void savePerson() throws Exception {

		Person person = new Person();
		person.setCnp("1");
		person.setName("John");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		connection.setAutoCommit(false);

		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into PERSOANA(cnp, nume) values(?,?)");
		preparedStatement.setString(1, person.getCnp() );
		preparedStatement.setString(2, person.getName());

		preparedStatement.execute();

		connection.commit();

		connection.close();

	}

	@Test
	public Person getPerson() throws Exception {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		connection.setAutoCommit(false);

		PreparedStatement preparedStatement = connection.prepareStatement("select * from PERSOANA where cnp = ?");
		preparedStatement.setString(1, "1");

		ResultSet resultSet = preparedStatement.executeQuery();

		assertTrue(resultSet.next());

		Person person = new Person();
		person.setCnp(resultSet.getString("cnp"));
		person.setName(resultSet.getString("name"));

		connection.commit();
		connection.close();

		return person;

	}

	@Test
	public void deletePerson() throws Exception {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		connection.setAutoCommit(false);

		PreparedStatement preparedStatement = connection.prepareStatement("delete from PERSOANA where cnp = ?");
		preparedStatement.setString(1, "1");

		int changedRows = preparedStatement.executeUpdate();

		assertTrue(changedRows == 1);

		connection.commit();
		connection.close();

	}
}
