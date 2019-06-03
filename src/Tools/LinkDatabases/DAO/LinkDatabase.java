package Tools.LinkDatabases.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LinkDatabase {

    public Connection getConnection() throws SQLException;

    public boolean saveData(String str) throws SQLException;

    public boolean updateData(String sql) throws SQLException;

    public ResultSet getInformation(String sql) throws SQLException;

}
