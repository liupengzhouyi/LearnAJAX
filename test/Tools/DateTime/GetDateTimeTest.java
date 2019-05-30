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
public class GetDateTimeTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(GetDateTime.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private GetDateTime getDateTime = null;

    public void createGetDateTime() {
        this.getDateTime = new GetDateTime();
    }

    public GetDateTime getGetDateTime() {
        return getDateTime;
    }

    public void setGetDateTime(GetDateTime getDateTime) {
        this.getDateTime = getDateTime;
    }

    @Before
    public void setUp() throws Exception {
        this.createGetDateTime();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() {
        System.out.println(this.getGetDateTime().getDateTime());
    }
}
