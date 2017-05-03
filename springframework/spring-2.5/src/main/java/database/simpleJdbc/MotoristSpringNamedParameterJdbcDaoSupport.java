package database.simpleJdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import database.beans.Motorist;

public class MotoristSpringNamedParameterJdbcDaoSupport extends NamedParameterJdbcDaoSupport {
	
	private static final String namedParametersInsertMotorist = "insert into motorist(id, email, password, firstName, lastName) "
			+ " values(null,:email, :password, :firstName, :lastName)";

	public void saveMotoristNamedParamters(Motorist motorist) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", motorist.getEmail());
		parameters.put("password", motorist.getPassword());
		parameters.put("firstName", motorist.getFirstName());
		parameters.put("lastName", motorist.getLastName());

		getNamedParameterJdbcTemplate().update(namedParametersInsertMotorist,
				parameters);

	}
}
