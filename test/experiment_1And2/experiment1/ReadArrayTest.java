package experiment_1And2.experiment1;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class ReadArrayTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ReadArray.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private ReadArray readArray = null;

    public void createReadArray() {
        this.readArray = new ReadArray();
    }

    public ReadArray getReadArray() {
        return readArray;
    }

    public void setReadArray(ReadArray readArray) {
        this.readArray = readArray;
    }

    @org.junit.Before
    public void setUp() throws Exception {
        this.createReadArray();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() {
        String[] strings = this.getReadArray().getStrings();
        for (String str:strings) {
            System.out.println(str);
        }
    }
}
