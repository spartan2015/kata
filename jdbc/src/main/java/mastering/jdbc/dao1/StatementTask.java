package mastering.jdbc.dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementTask
{
    PreparedStatement doStatement(Connection con) throws SQLException;
}