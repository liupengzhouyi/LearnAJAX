package Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools;

import Tools.LinkDatabases.DAO.LinkDatabase;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class LinkMySQLByDBCPSoftCoding implements LinkDatabase {

    public static DataSource dataSource = null;

    static {
        // 1.新建一个配置文件对象
        Properties prop = new Properties();
        try {
            //2.通过类加载器找到文件路径，读配置文件
            InputStream inputStream = new LinkMySQLByDBCPSoftCoding().getClass().getClassLoader().getResourceAsStream("config/dbcpconfig.properties");
            //3.把文件以输入流的形式加载到配置对象中
            prop.load(inputStream);
            //4.创建数据源对象
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public LinkMySQLByDBCPSoftCoding() throws SQLException {
        this.connection = dataSource.getConnection();
        this.statement = connection.createStatement();
    }

    private Connection connection = null;

    private Statement statement = null;

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
        //System.out.println("Tools.LinkDatabases.LinkMySQLByJDBC.LinkTools.LinkDatabases" + sql);
        ResultSet resultSet = this.statement.executeQuery(sql);
        return resultSet;
    }

    @Override
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

    /*public static void main(String[] args) throws SQLException {
        //5.获取数据库连接对象
        Connection conn = dataSource.getConnection();
        //6.获取数据库连接信息
        DatabaseMetaData metaData = conn.getMetaData();
        //7.打印数据库连接信息
        System.out.println(metaData.getURL() + ",UserName=" + metaData.getUserName() + "," + metaData.getDriverName());
    }*/
}
