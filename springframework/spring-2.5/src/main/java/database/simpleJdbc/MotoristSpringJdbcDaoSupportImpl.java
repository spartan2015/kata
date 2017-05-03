package database.simpleJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import database.beans.Motorist;

public class MotoristSpringJdbcDaoSupportImpl extends JdbcDaoSupport {
	private static final String insertMotorist = "insert into Motorist(id,email,password,firstName,lastName)"
			+ " values(null, ?, ?, ?, ?)";

	public void saveMotorist(Motorist motorist) {
		getJdbcTemplate().update(insertMotorist, new Object[] { motorist.getEmail(),
				motorist.getPassword(), motorist.getFirstName(),
				motorist.getLastName() });
	}

	private static final String queryMotorist = "select id, email, password,firstName,lastName from Motorist"
			+ " where id = ?";

	public Motorist getMotoristById(int id) {
		List matches = getJdbcTemplate().query(queryMotorist, new Object[] { Long
				.valueOf(id) }, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException,
					DataAccessException {
				Motorist motorist = new Motorist();
				motorist.setId(rs.getInt("id"));
				motorist.setEmail(rs.getString("email"));
				motorist.setPassword(rs.getString("password"));
				motorist.setFirstName(rs.getString("firstName"));
				motorist.setLastName(rs.getString("lastName"));
				return motorist;
			}
		});

		if (matches != null && matches.size() > 0) {
			return (Motorist) matches.get(0);
		} else {
			return null;
		}
	}
	
}
