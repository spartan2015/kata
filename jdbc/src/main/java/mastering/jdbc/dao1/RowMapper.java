package mastering.jdbc.dao1;

import java.sql.ResultSet;
import java.sql.SQLException;

interface RowMapper<T> {

	/**
	 * Method used to map a result entry to an Object
	 *
	 * @param rs
	 * @return - an object of type T containing the data of a ResultSet
	 *         entry
	 * @throws SQLException
	 */
	T mapRow(ResultSet rs) throws SQLException;

}