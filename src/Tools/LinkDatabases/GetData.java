package Tools.LinkDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetData {

    private LinkDatabases linkDatabases = null;

    private String sql = null;

    private ResultSet resultSet = null;

    public GetData(String sql) throws SQLException, ClassNotFoundException {
        this.init();
        this.setSql(sql);
        this.setResultSet(this.getLinkDatabases().getInformation(this.getSql()));
    }

    private void init() throws SQLException, ClassNotFoundException {
        this.createLinkDatabases();
        this.createSQL();
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

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
