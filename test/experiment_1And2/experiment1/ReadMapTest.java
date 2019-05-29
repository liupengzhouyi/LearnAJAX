package experiment_1And2.experiment1;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class ReadMapTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ReadMap.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private ReadMap readMap = null;

    public void createReadMap() {
        this.readMap = new ReadMap();
    }

    public ReadMap getReadMap() {
        return readMap;
    }

    public void setReadMap(ReadMap readMap) {
        this.readMap = readMap;
    }

    @Before
    public void setUp() throws Exception {
        this.createReadMap();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() {
        Map temp = this.getReadMap().getMyMap();
        System.out.println(temp);
    }
}
