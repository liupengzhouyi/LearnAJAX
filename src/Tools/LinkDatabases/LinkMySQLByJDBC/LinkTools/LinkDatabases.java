package Tools.LinkDatabases.LinkMySQLByJDBC.LinkTools;

import java.sql.*;

public class LinkDatabases {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/javaDatabase?useSSL=false&serverTimezone=UTC";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/TEST?useSSL=false&serverTimezone=UTC";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USERNAME = "root";
    static final String PASSWORD = "Lp184126";

    private Connection connection = null;

    private Statement statement = null;

    public LinkDatabases() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        this.createConnection();
        this.createStatement();
    }

    public void createConnection() throws SQLException {
        connection = DriverManager.getConnection(
                DB_URL,
                USERNAME,
                PASSWORD
        );
    }

    public Connection getConnection() throws SQLException {
        this.createConnection();
        if (connection == null) {
            this.createConnection();
            return connection;
        } else {
            return connection;
        }
    }

    public void createStatement() throws SQLException {
        if (this.statement != null) {
            return;
        } else {
            if (this.getConnection() == null) {
                this.createConnection();
            } else {
                this.statement = this.getConnection().createStatement();
            }
        }
    }

    public Statement getStatement() throws SQLException {
        if (this.connection == null) {
            this.createStatement();
        } else {
            this.statement = this.getConnection().createStatement();
        }
        return this.statement;
    }

    public boolean saveData(String str) throws SQLException {
        if (this.statement == null) {
            return false;
        } else {
            String string = str;
            this.statement.execute(string);
            return true;
        }
    }

    public boolean updateData(String sql) throws SQLException {
        if (this.statement == null) {
            return false;
        } else {
            String string = sql;
            if (sql.isEmpty()) {
                return false;
            } else {
                this.statement.executeUpdate(sql);
                return true;
            }

        }
    }

    public ResultSet getInformation(String sql) throws SQLException {
        //System.out.println("Tools.LinkDatabases.LinkMySQLByJDBC.LinkTools.LinkDatabases" + sql);
        ResultSet resultSet = this.statement.executeQuery(sql);
        return resultSet;
    }

}
