package experiment_9And10.experiment10.order.dao.Interface;

import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_1And2.experiment2.User;

import java.util.List;

public interface operationOrder {

    //添加订单
    public void addOrder(Order order);

    //按订单号查找订单
    public Order findOrderByOrderID(String orderID);

    //按时间查找订单
    public List<Order> findOrderByData(String orderData);

    //按时间范围查找所有订单
    public List<Order> findOrderByDates(String beginData, String endData);

    //按用户查找所有订单
    public List<Order> findOrderByUser(User user);

    //按商品查找所有订单
    public List<Order> findOrderByGood(Good good);
}
