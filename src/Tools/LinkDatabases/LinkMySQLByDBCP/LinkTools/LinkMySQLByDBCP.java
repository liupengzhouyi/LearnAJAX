package Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools;

import Tools.LinkDatabases.DAO.LinkDatabase;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;


/*
 * DBCP连接池在构建时需要引入
 * commons-collections
 * commons-dbcp2
 * commons-logging
 * commons-pool2
 * mysql-connector
 * 共五个jar包，缺一不可*/


/**
 * 本模块构建了一个DBCP连接池
 * DBCP连接池配置位于src/config/dbcpconfig.properties中
 * 连接数据库qzqmall user:root password:admin useSSL:false charset:utf8
 */
public class LinkMySQLByDBCP implements LinkDatabase {


    public LinkMySQLByDBCP() throws SQLException {
        try {
            Properties properties = new Properties();
            properties.load(LinkMySQLByDBCP.class.getClassLoader().getResourceAsStream("config/dbcpconfig.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);//得到一个连接池对象
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化连接错误，请检查配置文件！");
        }
        this.connection = dataSource.getConnection();
        this.statement = connection.createStatement();
    }

    //定义一个连接池对象
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            properties.load(LinkMySQLByDBCP.class.getClassLoader().getResourceAsStream("config/dbcpconfig.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);//得到一个连接池对象
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化连接错误，请检查配置文件！");
        }
    }



    /**
     * 关闭rs & stmt & conn
     *
     * @param rs   ResultSet
     * @param stmt Statement
     * @param conn Connection
     */
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();//关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection connection = null;

    private Statement statement = null;

    /**
     * 构造从连接池取出连接的方法
     *
     * @return Connection
     * @throws SQLException
     */
    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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

    @Override
    public boolean saveData(String str) throws SQLException {
        if (this.statement == null) {
            return false;
        } else {
            String string = str;
            this.statement.execute(string);
            return true;
        }
    }

    @Override
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

    @Override
    public ResultSet getInformation(String sql) throws SQLException {
        ResultSet resultSet = this.statement.executeQuery(sql);
        return resultSet;
    }

    /**
     * 测试类
     * @param args
     */
    /*public static void main(String[] args) {
        try {
            System.out.println("对DBCP池进行测试");
            Connection con = new LinkMySQLByDBCP().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            System.out.println(rs.next());
            closeAll(rs, stmt, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}