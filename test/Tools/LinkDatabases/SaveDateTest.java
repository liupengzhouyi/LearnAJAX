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
public class SaveDateTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(SaveDate.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private SaveDate saveDate = null;

    public void createSaveDate() throws SQLException, ClassNotFoundException {
        this.saveDate = new SaveDate("INSERT INTO `TEST`.`Employees` (`id`, `age`, `first`, `last`) VALUES (106, 24, 'liu', 'peng')");
    }

    public SaveDate getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(SaveDate saveDate) {
        this.saveDate = saveDate;
    }

    @Before
    public void setUp() throws Exception {
        this.createSaveDate();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() {

    }
}
