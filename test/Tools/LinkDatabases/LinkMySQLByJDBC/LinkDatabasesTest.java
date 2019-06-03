package Tools.LinkDatabases.LinkMySQLByJDBC;

import Tools.LinkDatabases.LinkMySQLByJDBC.LinkTools.LinkDatabases;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

//@RunWith(Arquillian.class)
public class LinkDatabasesTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(LinkDatabases.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private LinkDatabases linkDatabases = null;

    public void createLinkDatabases() throws ClassNotFoundException, SQLException {
        this.linkDatabases = new LinkDatabases();
    }

    public LinkDatabases getLinkDatabases() {
        return linkDatabases;
    }

    public void setLinkDatabases(LinkDatabases linkDatabases) {
        this.linkDatabases = linkDatabases;
    }

    @Before
    public void setUp() throws Exception {
        this.createLinkDatabases();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() throws SQLException {
        Connection connection = this.getLinkDatabases().getConnection();
        if (connection.equals(null)) {
            System.out.println("数据库连接失败！");
        } else {
            System.out.println("数据库连接成功！");
        }

    }
}
