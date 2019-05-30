package experiment_9And10.experiment10.user.dao.implement;

import Tools.ReturnInformation.ReturnInformation;
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
public class ImplementOperationUserTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ImplementOperationUser.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private ImplementOperationUser implementOperationUser = null;

    public void createImplementOperationUser() {
        this.implementOperationUser = new ImplementOperationUser();
    }

    public ImplementOperationUser getImplementOperationUser() {
        return implementOperationUser;
    }

    public void setImplementOperationUser(ImplementOperationUser implementOperationUser) {
        this.implementOperationUser = implementOperationUser;
    }

    @Before
    public void setUp() throws Exception {
        this.createImplementOperationUser();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void resetUser() {
    }

    @Test
    public void resetUserPassword() {
    }

    @Test
    public void howMoney() throws SQLException, ClassNotFoundException {
        String userID = "12KJB12312RFVG4";
        ReturnInformation returnInformation = this.getImplementOperationUser().howMoney(userID);
        returnInformation.toString();
    }

    @Test
    public void addMoney() {
    }

    @Test
    public void subMoney() {
    }

    @Test
    public void getUserByUserID() {
    }
}
