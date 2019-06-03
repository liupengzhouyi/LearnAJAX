package Tools.LinkDatabases.LinkMySQLByJDBC;

import Tools.LinkDatabases.LinkMySQLByJDBC.DataBaseTools.SaveData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

//@RunWith(Arquillian.class)
public class SaveDataTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(SaveData.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private SaveData SaveData = null;

    public void createSaveData() throws SQLException, ClassNotFoundException {
        this.SaveData = new SaveData("INSERT INTO `TEST`.`Employees` (`id`, `age`, `first`, `last`) VALUES (107, 24, 'liu', 'peng')");
    }

    public Tools.LinkDatabases.LinkMySQLByJDBC.DataBaseTools.SaveData getSaveData() {
        return SaveData;
    }

    public void setSaveData(SaveData SaveData) {
        this.SaveData = SaveData;
    }

    @Before
    public void setUp() throws Exception {
        this.createSaveData();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() {

    }
}
