package com.fortech.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDao {

	@Autowired
	DataSource dataSource;
	JdbcTemplate template;
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(dataSource);
	}

	void saveJpa(final Book book) {
		
		entityManager.persist(book);
		
	}

	void save1(final Book book) {
		template.execute(new ConnectionCallback<Void>() {

			public Void doInConnection(Connection c) throws SQLException, DataAccessException {

				PreparedStatement st = c.prepareStatement("insert into book(id,title) values(?,?) ");

				st.setLong(1, book.getId());
				st.setString(2, book.getTitle());

				st.execute();

				return null;
			}

		});
	}

	void save(Book book) {

		try {
			Connection c = dataSource.getConnection();

			PreparedStatement st = c.prepareStatement("insert into book(id,title) values(?,?) ");

			st.setLong(1, book.getId());
			st.setString(2, book.getTitle());

			st.execute();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
