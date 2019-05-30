package Tools.LinkDatabases;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import static org.junit.Assert.*;

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

    public SaveData getSaveData() {
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
