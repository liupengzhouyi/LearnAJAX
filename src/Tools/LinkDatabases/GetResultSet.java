package Tools.LinkDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetResultSet {

    private LinkDatabases linkDatabases = null;

    private String sql = null;

    private boolean key = false;

    private ResultSet resultSet = null;

    public GetResultSet(String sql) throws SQLException, ClassNotFoundException {
        this.init();
        this.setSql(sql);
        this.setResultSet(this.getLinkDatabases().getInformation(this.getSql()));
        if (this.getResultSet() == null) {
            this.setKey(false);
        } else {
            this.setKey(true);
        }
    }

    public void init() throws SQLException, ClassNotFoundException {
        this.createSQL();
        this.createLinkDatabases();
        this.createResultSet();
    }

    public void createLinkDatabases() throws SQLException, ClassNotFoundException {
        this.linkDatabases = new LinkDatabases();
    }

    public LinkDatabases getLinkDatabases() {
        return linkDatabases;
    }

    public void setLinkDatabases(LinkDatabases linkDatabases) {
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
