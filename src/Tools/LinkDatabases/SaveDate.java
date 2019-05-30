package Tools.LinkDatabases;

import java.sql.SQLException;

public class SaveDate {

    private LinkDatabases linkDatabases = null;

    private String sql = null;

    public void createLinkDatabases() throws ClassNotFoundException, SQLException {
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

    public void init() throws ClassNotFoundException, SQLException {
        this.createLinkDatabases();
        this.createSQL();
    }

    public SaveDate(String sql) throws SQLException, ClassNotFoundException {
        this.init();
        this.setSql(sql);
        this.getLinkDatabases().saveData(this.getSql());
    }
}
