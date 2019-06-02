package experiment_9And10.experiment10.order.dao.implement;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_1And2.experiment2.User;
import experiment_9And10.experiment10.order.dao.Interface.operationOrder;

import java.util.List;

public class implementOperationOrder implements operationOrder {

    @Override
    public ReturnInformation addOrder(Order order) {
        ReturnInformation returnInformation = null;
        if (order.equals(null)) {
            String sql = "insert into myOrder(" +
                    "orderID, " +
                    "userID, " +
                    "goodID, " +
                    "number, " +
                    "the_unit_price, " +
                    "the_total_price, " +
                    "date, " +
                    "time) value (" +
                    "1, " +
                    "\'" + order.getUserID() + "\', " +
                    "1, " +
                    "123, " +
                    "12.99, " +
                    "1234, " +
                    "'', " +
                    "'');";
        } else {
            //参数传递错误

        }

        return returnInformation;
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
