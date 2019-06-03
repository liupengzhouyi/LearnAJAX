package Tools.LinkDatabases.LinkMySQLByJDBC;

import Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools.LinkDataBasesByDBCP;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

//@RunWith(Arquillian.class)
public class LinkDataBasesByDBCPTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(LinkDataBasesByDBCP.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private LinkDataBasesByDBCP linkDataBasesByDBCP = null;

    public LinkDataBasesByDBCP getLinkDataBasesByDBCP() {
        return linkDataBasesByDBCP;
    }

    public void setLinkDataBasesByDBCP(LinkDataBasesByDBCP linkDataBasesByDBCP) {
        this.linkDataBasesByDBCP = linkDataBasesByDBCP;
    }

    @Before
    public void setUp() throws Exception {
        linkDataBasesByDBCP = new LinkDataBasesByDBCP();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() throws SQLException, NamingException {
        Connection connection = this.getLinkDataBasesByDBCP().getConnection();
        if (connection != null) {
            System.out.println("pwd");
        } else {
            System.out.println("abc");
        }
    }
}
