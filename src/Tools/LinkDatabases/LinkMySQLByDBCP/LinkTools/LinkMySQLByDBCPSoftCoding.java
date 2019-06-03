package Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class LinkMySQLByDBCPSoftCoding {
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

    public static void main(String[] args) throws SQLException {
        //5.获取数据库连接对象
        Connection conn = dataSource.getConnection();
        //6.获取数据库连接信息
        DatabaseMetaData metaData = conn.getMetaData();
        //7.打印数据库连接信息
        System.out.println(metaData.getURL() + ",UserName=" + metaData.getUserName() + "," + metaData.getDriverName());
    }
}
