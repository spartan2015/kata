package database.simpleJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import database.beans.Motorist;

public class MotoristSpringSimpleJdbcDaoSupport extends SimpleJdbcDaoSupport {
	
	private static final String insertMotorist = "insert into Motorist(id,email,password,firstName,lastName)" +
	" values(null, ?, ?, ?, ?)";
	
	private static final String queryMotorist = "select id, email, password,firstName,lastName from Motorist" +
	" where id = ?";
	
	public void saveMotoristJava5Style(Motorist motorist) {
		getSimpleJdbcTemplate()
				.update(insertMotorist, motorist.getEmail(), motorist
						.getPassword(), motorist.getFirstName(), motorist
						.getLastName());
	}

	public Motorist getMotoristByIdJava5Style(int id) {
		List<Motorist> matches = getSimpleJdbcTemplate().query(queryMotorist,
				new ParameterizedRowMapper<Motorist>() {
					public Motorist mapRow(ResultSet rs, int rowNum)
							throws SQLException, DataAccessException {
						Motorist motorist = new Motorist();
						motorist.setId(rs.getInt("id"));
						motorist.setEmail(rs.getString("email"));
						motorist.setPassword(rs.getString("password"));
						motorist.setFirstName(rs.getString("firstName"));
						motorist.setLastName(rs.getString("lastName"));
						return motorist;
					}
				}, id);

		if (matches != null && matches.size() > 0) {
			return matches.get(0);
		} else {
			return null;
		}
	}

}
