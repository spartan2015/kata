package mastering.jdbc.dao1;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementTask
{
    void doStatement(PreparedStatement preparedStatement) throws SQLException;
}