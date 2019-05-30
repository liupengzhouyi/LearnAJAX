package Tools.DateTime;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class GetDateTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(GetDate.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private GetDate getDate = null;

    public void createGetDate() {
        this.getDate = new GetDate();
    }

    public GetDate getGetDate() {
        return getDate;
    }

    public void setGetDate(GetDate getDate) {
        this.getDate = getDate;
    }

    @Test
    public void paly() {
        System.out.println(this.getGetDate().getString());
    }

    @Before
    public void setUp() throws Exception {
        this.createGetDate();
    }

    @After
    public void tearDown() throws Exception {
    }
}
