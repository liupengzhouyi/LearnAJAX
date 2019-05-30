package Tools.Math;

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
public class DoubleToStringTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(DoubleToString.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private DoubleToString doubleToString = null;

    public void createDoubleToString() {
        this.doubleToString = new DoubleToString(123.456);
    }

    public DoubleToString getDoubleToString() {
        return doubleToString;
    }

    public void setDoubleToString(DoubleToString doubleToString) {
        this.doubleToString = doubleToString;
    }

    @Before
    public void setUp() throws Exception {
        this.createDoubleToString();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() {
        System.out.println(this.getDoubleToString().getStrDouble());
    }
}
