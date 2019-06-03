package Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools;

import Tools.LinkDatabases.DAO.LinkDatabase;
import Tools.LinkDatabases.LinkMySQLByJDBC.LinkTools.LinkDatabases;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LinkDataBasesByDBCP implements LinkDatabase {
    public LinkDataBasesByDBCP() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/javaDatabase");
        this.connection = ds.getConnection();
        this.statement = connection.createStatement();
    }

    @Override
    public boolean saveData(String str) throws SQLException {
        return false;
    }

    @Override
    public boolean updateData(String sql) throws SQLException {
        return false;
    }

    @Override
    public ResultSet getInformation(String sql) throws SQLException {
        return null;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    Connection connection = null;

    Statement statement = null;
}
