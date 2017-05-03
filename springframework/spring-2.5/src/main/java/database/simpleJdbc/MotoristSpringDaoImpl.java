package database.simpleJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import database.beans.Motorist;

public class MotoristSpringDaoImpl implements MotoristSpringDao{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String insertMotorist = "insert into Motorist(id,email,password,firstName,lastName)" +
			" values(null, ?, ?, ?, ?)";
	
	public void saveMotorist(Motorist motorist) {
		jdbcTemplate.update(insertMotorist, new Object[]{motorist.getEmail(),motorist.getPassword(),
				motorist.getFirstName(),motorist.getLastName()});
	}	
	
	private static final String queryMotorist = "select id, email, password,firstName,lastName from Motorist" +
			" where id = ?";
	
	public Motorist getMotoristById(int id){
		List matches = jdbcTemplate.query(queryMotorist, new Object[]{Long.valueOf(id)}, new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException{
				Motorist motorist = new Motorist();
				motorist.setId(rs.getInt("id"));
				motorist.setEmail(rs.getString("email"));
				motorist.setPassword(rs.getString("password"));
				motorist.setFirstName(rs.getString("firstName"));
				motorist.setLastName(rs.getString("lastName"));
				return motorist;
			}
		});
		
		if (matches != null && matches.size() > 0){
			return (Motorist)matches.get(0);
		}else{
			return null;
		}
	}
	
	
	/**
	 * NAMED PARAMETERS EXAMPLE
	 */
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private static final String namedParametersInsertMotorist = "insert into motorist(id, email, password, firstName, lastName) " +
			" values(null,:email, :password, :firstName, :lastName)";
	
	public void saveMotoristNamedParamters(Motorist motorist){
		Map<String,Object> parameters = new HashMap<String,Object>();		
		parameters.put("email", motorist.getEmail());
		parameters.put("password", motorist.getPassword());
		parameters.put("firstName", motorist.getFirstName());
		parameters.put("lastName", motorist.getLastName());
		
		namedParameterJdbcTemplate.update(namedParametersInsertMotorist, parameters);
		
	}
	
	/**
	 * Java 5 style 
	 */	
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}
	
	public void saveMotoristJava5Style(Motorist motorist){
		simpleJdbcTemplate.update(insertMotorist, motorist.getEmail(), motorist.getPassword(),
				motorist.getFirstName(), motorist.getLastName());
	}	
	
	public Motorist getMotoristByIdJava5Style(int id){
		List<Motorist> matches = simpleJdbcTemplate.query(queryMotorist, new ParameterizedRowMapper<Motorist>(){
			public Motorist mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException{
				Motorist motorist = new Motorist();
				motorist.setId(rs.getInt("id"));
				motorist.setEmail(rs.getString("email"));
				motorist.setPassword(rs.getString("password"));
				motorist.setFirstName(rs.getString("firstName"));
				motorist.setLastName(rs.getString("lastName"));
				return motorist;
			}
		}, 
		id
		);
		
		if (matches != null && matches.size() > 0){
			return matches.get(0);
		}else{
			return null;
		}
	}
}