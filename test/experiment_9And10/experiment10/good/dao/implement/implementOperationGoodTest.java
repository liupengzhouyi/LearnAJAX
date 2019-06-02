package experiment_9And10.experiment10.good.dao.implement;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
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
import java.util.List;

//@RunWith(Arquillian.class)
public class implementOperationGoodTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ImplementOperationGood.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private Good good = null;

    private ImplementOperationGood implementOperationGood = null;

    private ReturnInformation returnInformation = null;

    public void createGood() {
        this.good = new Good("default");
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public void createImplementOperationGood() {
        this.implementOperationGood = new ImplementOperationGood();
    }

    public ImplementOperationGood getImplementOperationGood() {
        return implementOperationGood;
    }

    public void setImplementOperationGood(ImplementOperationGood implementOperationGood) {
        this.implementOperationGood = implementOperationGood;
    }

    public ReturnInformation getReturnInformation() {
        return returnInformation;
    }

    public void setReturnInformation(ReturnInformation returnInformation) {
        this.returnInformation = returnInformation;
    }

    @Before
    public void setUp() throws Exception {
        this.createImplementOperationGood();
        this.createGood();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGood() throws SQLException, ClassNotFoundException {
        this.setReturnInformation(this.getImplementOperationGood().addGood(this.getGood()));
        System.out.println(getReturnInformation().toString());
    }

    @Test
    public void resetGood() {
    }

    @Test
    public void resetGoodPrice() {
    }

    @Test
    public void eliminateGood() {
    }

    @Test
    public void findAllGood() {
    }

    @Test
    public void findAllEliminateGood() {
    }

    @Test
    public void findAllNotEliminateGood() throws SQLException, ClassNotFoundException {
        this.setReturnInformation(this.getImplementOperationGood().findAllNotEliminateGood());
        if (this.getReturnInformation().getResult().equals("success")) {
            //获取商品数据成功
            System.out.println(this.getReturnInformation().toString());
            System.out.println(this.getReturnInformation().getType());
            if (this.getReturnInformation().getType().equals("List<Good>")) {
                List<Good> list = (List<Good>) this.getReturnInformation().getObject();
                for (Good good:list) {
                    System.out.println(good.toString());
                }
            } else {
                System.out.println("返回值类型错误");
            }
        } else {
            //获取商品数据失败
            System.out.println(this.getReturnInformation().toString());
        }

    }

    @Test
    public void goodIsExistence() throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = this.getImplementOperationGood().goodIsExistence("65");
        System.out.println(returnInformation.toString());
    }

    @Test
    public void findGoodByGoodID() throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = this.getImplementOperationGood().findGoodByGoodID("1");
        System.out.println(returnInformation.toString());
    }
}
