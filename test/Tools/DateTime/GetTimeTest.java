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
public class GetTimeTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(GetTime.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private GetTime getTime = null;

    public void createGetTime() {
        this.getTime = new GetTime();
    }

    public GetTime getGetTime() {
        return getTime;
    }

    public void setGetTime(GetTime getTime) {
        this.getTime = getTime;
    }

    @Test
    public void paly() {
        System.out.println(this.getGetTime().getTime());
    }

    @Before
    public void setUp() throws Exception {
        this.createGetTime();
    }

    @After
    public void tearDown() throws Exception {
    }
}
