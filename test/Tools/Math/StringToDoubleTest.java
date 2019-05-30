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
public class StringToDoubleTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(StringToDouble.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private StringToDouble stringToDouble = null;

    public void createStringToDouble() {
        this.stringToDouble = new StringToDouble("1233");
    }

    public StringToDouble getStringToDouble() {
        return stringToDouble;
    }

    public void setStringToDouble(StringToDouble stringToDouble) {
        this.stringToDouble = stringToDouble;
    }

    @Before
    public void setUp() throws Exception {
        this.createStringToDouble();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() {
        System.out.println(this.getStringToDouble().getNumber());
    }
}
