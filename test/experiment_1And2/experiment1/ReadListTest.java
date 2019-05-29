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

import java.util.List;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class ReadListTest {
   /* @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ReadList.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private ReadList readList = null;

    public ReadList getReadList() {
        return readList;
    }

    public void setReadList(ReadList readList) {
        this.readList = readList;
    }

    public void createReadList() {
        this.readList = new ReadList();
    }

    @Before
    public void setUp() throws Exception {
        this.createReadList();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void paly() {
        List<String> list = this.getReadList().getList();
        for(String str:list) {
            System.out.println(str);
        }

    }
}
