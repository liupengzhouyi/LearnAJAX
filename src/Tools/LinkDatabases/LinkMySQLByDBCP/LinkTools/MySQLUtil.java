package Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class MySQLUtil {

    private String dataSourceName;
    private DataSource ds;

    public MySQLUtil(String dataSourceName) {
        this.dataSourceName=dataSourceName;
    }

    public MySQLUtil() {
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName=dataSourceName;
    }
    public void init() {
        Context initContext;
        try {
            initContext = new InitialContext();
            ds = (DataSource) initContext.lookup(dataSourceName);
        }catch(NamingException e) {
            e.printStackTrace();
        }
    }
    public int update(String sql, String[] parm) {
        int result = 0;
        QueryRunner qr = new QueryRunner(ds);
        try {
            result = qr.update(sql,parm);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Object query(String sql,ResultSetHandler rsh) {
        QueryRunner qr = new QueryRunner(ds);
        Object result = null;
        try {
            result = qr.query(sql,rsh);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}


