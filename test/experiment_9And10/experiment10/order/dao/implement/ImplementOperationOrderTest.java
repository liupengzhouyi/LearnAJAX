package experiment_9And10.experiment10.order.dao.implement;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_1And2.experiment2.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

//@RunWith(Arquillian.class)
public class ImplementOperationOrderTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ImplementOperationOrder.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private ImplementOperationOrder implementOperationOrder = null;

    private Order order = null;

    public ImplementOperationOrder getImplementOperationOrder() {
        return implementOperationOrder;
    }

    public void setImplementOperationOrder(ImplementOperationOrder implementOperationOrder) {
        this.implementOperationOrder = implementOperationOrder;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Before
    public void setUp() throws Exception {
        this.implementOperationOrder = new ImplementOperationOrder();
        this.order = new Order("default");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addOrder() throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = this.getImplementOperationOrder().addOrder(this.getOrder());
        System.out.println(returnInformation.toString());
    }

    @Test
    public void findOrderByOrderID() throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = this.getImplementOperationOrder().findOrderByOrderID("1");
        System.out.println(returnInformation.toString());
        System.out.println((Object) returnInformation.getObject().toString());
    }

    @Test
    public void findOrderByData() throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = this.getImplementOperationOrder().findOrderByData("2019-06-03");
        System.out.println(returnInformation.toString());
    }

    @Test
    public void findOrderByDates() {
    }

    @Test
    public void findOrderByUser()  throws SQLException, ClassNotFoundException{
        User user = new User("default");
        user.setUserID("12KJB12312RFVG4");
        ReturnInformation returnInformation = this.getImplementOperationOrder().findOrderByUser(user);
        System.out.println(returnInformation.toString());
    }

    @Test
    public void findOrderByGood()  throws SQLException, ClassNotFoundException{
        Good good = new Good("default");
        ReturnInformation returnInformation = this.getImplementOperationOrder().findOrderByGood(good);
        System.out.println(returnInformation.toString());
    }

    @Test
    public void findOrderPaging() throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = this.getImplementOperationOrder().findOrderPaging(1, 5);
        List<Order> list = (List<Order>) returnInformation.getObject();
        for (Order order: list) {
            System.out.println(order.toString());
        }
    }

    @Test
    public void ordersumber() throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = this.getImplementOperationOrder().ordersumber();
        System.out.println(returnInformation.toString());
    }
}
