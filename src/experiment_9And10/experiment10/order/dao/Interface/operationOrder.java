package experiment_9And10.experiment10.order.dao.Interface;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_1And2.experiment2.User;

import java.sql.SQLException;
import java.util.List;

public interface operationOrder {

    //添加订单
    public ReturnInformation addOrder(Order order) throws SQLException, ClassNotFoundException;

    //按订单号查找订单
    public ReturnInformation findOrderByOrderID(String orderID) throws SQLException, ClassNotFoundException;

    //按时间查找订单
    public ReturnInformation findOrderByData(String orderData) throws SQLException, ClassNotFoundException;

    //按时间范围查找所有订单
    public ReturnInformation findOrderByDates(String beginData, String endData);

    //按用户查找所有订单
    public ReturnInformation findOrderByUser(User user) throws SQLException, ClassNotFoundException;

    //按商品查找所有订单
    public ReturnInformation findOrderByGood(Good good) throws SQLException, ClassNotFoundException;

    //分页显示数据
    public ReturnInformation findOrderPaging(int number, int maxDate) throws SQLException, ClassNotFoundException;


    public ReturnInformation ordersumber() throws SQLException, ClassNotFoundException;
}
