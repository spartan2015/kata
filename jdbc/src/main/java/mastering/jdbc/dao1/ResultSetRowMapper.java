package mastering.jdbc.dao1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetRowMapper<T> implements ResultSetExtractor<List<T>> {

	private RowMapper<T> rowMapper;

	public ResultSetRowMapper(RowMapper<T> rowMapper) {
		this.rowMapper = rowMapper;
	}

	@Override
	public List<T> extractData(ResultSet rs) throws SQLException {
		List<T> result = new ArrayList<T>();
		int rowNumber = 0;
		while (rs.next()) {
			result.add(rowMapper.mapRow(rs));
		}

		return result;
	}

}