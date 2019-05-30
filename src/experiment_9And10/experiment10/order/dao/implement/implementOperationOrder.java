package experiment_9And10.experiment10.order.dao.implement;

import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_1And2.experiment2.User;
import experiment_9And10.experiment10.order.dao.Interface.operationOrder;

import java.util.List;

public class implementOperationOrder implements operationOrder {

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order findOrderByOrderID(String orderID) {
        return null;
    }

    @Override
    public List<Order> findOrderByData(String orderData) {
        return null;
    }

    @Override
    public List<Order> findOrderByDates(String beginData, String endData) {
        return null;
    }

    @Override
    public List<Order> findOrderByUser(User user) {
        return null;
    }

    @Override
    public List<Order> findOrderByGood(Good good) {
        return null;
    }

}
