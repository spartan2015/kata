package mastering.jdbc.dao1;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
		 * Used to create data extractors from ResultSet
		 *
		 *
		 * @param <T>
		 *            - the type of the object to which the ResultSet is
		 *            mapped
		 */
public interface ResultSetExtractor<T> {
	/**
	 * Signature of the method used to the mapping/extraction of the
	 * ResultSet
	 *
	 * @param rs
	 *            - the ResultSet
	 * @return - an object containing the relevant data from ResultSet
	 * @throws SQLException
	 */
	T extractData(ResultSet rs) throws SQLException;
}