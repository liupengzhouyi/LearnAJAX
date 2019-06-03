package experiment_9And10.experiment10.order.dao.implement;

import Tools.DateTime.GetDate;
import Tools.DateTime.GetTime;
import Tools.LinkDatabases.GetResultSet;
import Tools.LinkDatabases.SaveData;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_1And2.experiment2.User;
import experiment_9And10.experiment10.order.dao.Interface.operationOrder;
import org.apache.bcel.generic.FieldGenOrMethodGen;

import java.sql.SQLException;
import java.util.List;

public class ImplementOperationOrder implements operationOrder {

    @Override
    public ReturnInformation addOrder(Order order) throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        if (!order.equals(null)) {
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
                    order.getGoodID() +", " +
                    order.getNumber() + ", " +
                    order.getThe_unit_price() + ", " +
                    order.getThe_total_price() + ", " +
                    "\'" + new GetDate().getMyDaye() + "\', " +
                    "\'" + new GetTime().getTime() + "\');";
            SaveData saveData = new SaveData(sql);
            if (saveData.isKey()) {
                //保存数据成功
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                        "保存订单数据成功",
                        "保存订单数据成功",
                        "success");
            } else {
                //保存数据失败
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                        "保存订单数据失败",
                        "保存订单数据失败",
                        "fail");
            }
        } else {
            //参数传递错误
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }

        return returnInformation;
    }

    @Override
    public ReturnInformation findOrderByOrderID(String orderID) throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        if (!orderID.isEmpty()) {
            //参数传递没有错误
            String sql = "select * from myOrder where orderID = \'" + orderID + "\';";
            GetResultSet getResultSet = new GetResultSet(sql);
            if (getResultSet.isKey()) {
                Order order = null;
                while (getResultSet.getResultSet().next()){
                    order = new Order();
                    order.setOrderID(getResultSet.getResultSet().getString("orderID"));
                    order.setUserID(getResultSet.getResultSet().getString("userID"));
                    order.setGoodID(getResultSet.getResultSet().getString("goodID"));
                    order.setThe_unit_price(getResultSet.getResultSet().getDouble("the_unit_price"));
                    order.setThe_total_price(getResultSet.getResultSet().getDouble("the_total_price"));
                    order.setTime(getResultSet.getResultSet().getString("time"));
                    order.setDate(getResultSet.getResultSet().getString("date"));
                }
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                        "获取到订单",
                        "获取订单成功",
                        "success");
                returnInformation.setType("Order");
                returnInformation.setObject(order);

            } else {
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                        "在没在数据库中获取到订单",
                        "获取订单失败",
                        "fail");
            }
        } else {
            //参数传递有错误
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }
        return returnInformation;
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
