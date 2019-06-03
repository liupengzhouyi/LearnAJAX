package Tools.LinkDatabases.LinkMySQLByDBCP;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class LinkMySQLByDBCPHardCoded {

    public static DataSource dataSource = null;

    static {
        //1.获取DBCP数据源实现类对象
        BasicDataSource basicDataSource = new BasicDataSource();
        //2.设置连接数据库需要的配置信息
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/javaDatabase?useSSL=false&serverTimezone=UTC");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("Lp184126");
        //3.设置连接池的参数
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxWaitMillis(10);
        dataSource = basicDataSource;
    }
    public static void main(String[] args) throws SQLException {
        //4.获取数据库连接对象
        Connection conn = dataSource.getConnection();
        //5.获取数据库连接信息
        DatabaseMetaData metaData = conn.getMetaData();
        //6.打印数据库连接信息
        System.out.println(metaData.getURL()
                +",UserName="+metaData.getUserName()
                +","+metaData.getDriverName());
    }
}
