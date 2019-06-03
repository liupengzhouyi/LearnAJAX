package Tools.LinkDatabases;

import Tools.LinkDatabases.LinkMySQLByJDBC.GetData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

//@RunWith(Arquillian.class)
public class GetDataTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(GetData.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/


    private GetData getData = null;

    private String sql = null;

    public void createGetData() throws SQLException, ClassNotFoundException {
        this.getData = new GetData(this.getSql());
    }

    public GetData getGetData() {
        return getData;
    }

    public void setGetData(GetData getData) {
        this.getData = getData;
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

    public void init() throws SQLException, ClassNotFoundException {
        this.createSQL();
        this.setSql("select * from user;");
        this.createGetData();
    }

    @Before
    public void setUp() throws Exception {
        this.init();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() throws SQLException {
        ResultSet resultSet = this.getGetData().getResultSet();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("userID"));
        }
    }
}
