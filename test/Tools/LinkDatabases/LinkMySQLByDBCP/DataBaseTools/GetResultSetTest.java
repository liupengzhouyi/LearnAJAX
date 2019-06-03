package Tools.LinkDatabases.LinkMySQLByDBCP.DataBaseTools;

import Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools.LinkDataBasesByDBCP;
import Tools.LinkDatabases.LinkMySQLByDBCP.DataBaseTools.GetResultSet;
import experiment_1And2.experiment2.Good;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.NamingException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class GetResultSetTest {

    private GetResultSet getResultSet = null;


    private String sql = null;

    GetResultSetTest() throws SQLException, NamingException, ClassNotFoundException {
    }

    public GetResultSet getGetResultSet() {
        return getResultSet;
    }

    public void setGetResultSet(GetResultSet getResultSet) {
        this.getResultSet = getResultSet;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException, NamingException {
        this.setSql("select * from user;");
        this.getResultSet = new GetResultSet("select * from user;");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void init() {
    }

    @Test
    void createLinkDatabases() {
    }

    @Test
    void getLinkDatabases() {
    }

    @Test
    void setLinkDatabases() {
    }

    @Test
    void createSQL() {
    }

    @Test
    void getSql() {
        System.out.println(this.getGetResultSet().getSql());
    }

    @Test
    void setSql() {
    }

    @Test
    void isKey() {
    }

    @Test
    void setKey() {
    }

    @Test
    void createResultSet() {
    }

    @Test
    void getResultSet() throws SQLException {
        while(getGetResultSet().getResultSet().next()) {
            System.out.println(getGetResultSet().getResultSet().getString("userID"));
        }
    }

    @Test
    void setResultSet() {
    }
}