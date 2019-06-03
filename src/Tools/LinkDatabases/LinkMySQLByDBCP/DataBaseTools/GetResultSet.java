package Tools.LinkDatabases.LinkMySQLByDBCP.DataBaseTools;

import Tools.LinkDatabases.DAO.LinkDatabase;
import Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools.LinkDataBasesByDBCP;
import Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools.LinkMySQLByDBCP;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetResultSet {

    private LinkDatabase linkDatabases = null;

    private String sql = null;

    private boolean key = false;

    private ResultSet resultSet = null;

    public GetResultSet(String sql) throws SQLException, ClassNotFoundException, NamingException {
        this.init();
        this.setSql(sql);
        this.setResultSet(this.getLinkDatabases().getInformation(this.getSql()));
        if (this.getResultSet().next()) {
            this.setKey(true);
            this.getResultSet().previous();
        } else {
            this.setKey(false);
        }
    }

    public void init() throws SQLException, ClassNotFoundException, NamingException {
        this.createSQL();
        this.createLinkDatabases();
        this.createResultSet();
    }

    public void createLinkDatabases() throws SQLException, ClassNotFoundException, NamingException {
        this.linkDatabases = new LinkMySQLByDBCP();
    }

    public LinkDatabase getLinkDatabases() {
        return linkDatabases;
    }

    public void setLinkDatabases(LinkMySQLByDBCP linkDatabases) {
        this.linkDatabases = linkDatabases;
    }

    public void createSQL() {
        this.sql = new String();
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public void createResultSet() {
        this.resultSet = null;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
