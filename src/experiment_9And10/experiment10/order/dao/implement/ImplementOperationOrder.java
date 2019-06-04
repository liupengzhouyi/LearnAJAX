package experiment_9And10.experiment10.order.dao.implement;

import Tools.DateTime.GetDate;
import Tools.DateTime.GetTime;
import Tools.LinkDatabases.LinkMySQLByJDBC.DataBaseTools.GetResultSet;
import Tools.LinkDatabases.LinkMySQLByJDBC.DataBaseTools.SaveData;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_1And2.experiment2.User;
import experiment_9And10.experiment10.order.dao.Interface.operationOrder;
import org.apache.xpath.operations.Or;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementOperationOrder implements operationOrder {

    /**
     * 添加订单
     * @param order
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation addOrder(Order order) throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        if (!order.equals(null)) {
            String sql = "insert into myOrder(" +
                    "userID, " +
                    "goodID, " +
                    "number, " +
                    "the_unit_price, " +
                    "the_total_price, " +
                    "date, " +
                    "time) value (" +
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

    /**
     * 通过订单编号查询订单
     * @param orderID
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
                    order = this.encapsulationOrder(order, getResultSet.getResultSet());
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

    /**
     * 通过日期获取订单
     * @param orderDate
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation findOrderByData(String orderDate) throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        if (!orderDate.isEmpty()) {
            //参数传递没有错误
            String sql = "select * from myOrder where date = \'" + orderDate + "\';";
            GetResultSet getResultSet = new GetResultSet(sql);
            if (getResultSet.isKey()) {
                Order order = null;
                List<Order> list = new ArrayList<Order>();
                while (getResultSet.getResultSet().next()){
                    order = new Order();
                    order = this.encapsulationOrder(order, getResultSet.getResultSet());
                    list.add(order);
                }
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByData",
                        "获取到订单",
                        "获取订单成功",
                        "success");
                returnInformation.setType("List<Order>");
                returnInformation.setObject(list);

            } else {
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByData",
                        "在没在数据库中获取到订单",
                        "获取订单失败",
                        "fail");
            }
        } else {
            //参数传递有错误
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByData",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }
        return returnInformation;
    }

    @Override
    public ReturnInformation findOrderByDates(String beginData, String endData) {
        return null;
    }

    /**
     * 获取某个用户的所有订单
     * @param user
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation findOrderByUser(User user) throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        if (user != null) {
            //参数传递没有错误
            String sql = "select * from myOrder where userID = \'" + user.getUserID() + "\';";
            GetResultSet getResultSet = new GetResultSet(sql);
            if (getResultSet.isKey()) {
                List<Order> list = new ArrayList<Order>();
                Order order = null;
                while (getResultSet.getResultSet().next()){
                    order = new Order();
                    order = this.encapsulationOrder(order, getResultSet.getResultSet());
                    list.add(order);
                }
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByUser",
                        "获取到订单",
                        "获取订单成功",
                        "success");
                returnInformation.setType("List<Order>");
                returnInformation.setObject(list);

            } else {
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByUser",
                        "在没在数据库中获取到订单",
                        "获取订单失败",
                        "fail");
            }
        } else {
            //参数传递有错误
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByUser",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }
        return returnInformation;
    }

    /**
     * 获取某一个商品的所有订单
     * @param good
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation findOrderByGood(Good good) throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        if (good != null) {
            //参数传递没有错误
            String sql = "select * from myOrder where goodID = \'" + good.getGoodID() + "\';";
            GetResultSet getResultSet = new GetResultSet(sql);
            if (getResultSet.isKey()) {
                List<Order> list = new ArrayList<Order>();
                Order order = null;
                while (getResultSet.getResultSet().next()){
                    order = new Order();
                    order = this.encapsulationOrder(order, getResultSet.getResultSet());
                    list.add(order);
                }
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByGood",
                        "获取到订单",
                        "获取订单成功",
                        "success");
                returnInformation.setType("List<Order>");
                returnInformation.setObject(list);

            } else {
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByGood",
                        "在没在数据库中获取到订单",
                        "获取订单失败",
                        "fail");
            }
        } else {
            //参数传递有错误
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.findOrderByGood",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }
        return returnInformation;
    }

    /**
     * 分页显示数据
     * @param number
     * @param maxData
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation findOrderPaging(int number, int maxData) throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        //参数传递没有错误
        String sql = "select * from myOrder where orderID >= " + number*maxData + " and orderID < " + (1+number)*maxData + ";";
        GetResultSet getResultSet = new GetResultSet(sql);
        if (getResultSet.isKey()) {
            List<Order> list = new ArrayList<Order>();
            Order order = null;
            while (getResultSet.getResultSet().next()){
                order = new Order();
                order = this.encapsulationOrder(order, getResultSet.getResultSet());
                list.add(order);
            }
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                    "获取到订单",
                    "获取订单成功",
                    "success");
            returnInformation.setType("List<Order>");
            returnInformation.setObject(list);

        } else {
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                    "在没在数据库中获取到订单",
                    "获取订单失败",
                    "fail");
        }
        return returnInformation;
    }

    /**
     * 获取订单数量
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation ordersumber() throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        String sql = "select orderID from myOrder;";
        GetResultSet getResultSet = new GetResultSet(sql);
        if (getResultSet.isKey()) {
            int number = -1;
            //获取到数据
            while(getResultSet.getResultSet().next()) {
                number = getResultSet.getResultSet().getInt("orderID");
            }
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                    "获取到数据",
                    "获取订单数量成功",
                    "success");
            returnInformation.setType("int");
            returnInformation.setObject(number);
        } else {
            //没有获取到数据
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder.addOrder",
                    "在没在数据库中获取到订单",
                    "获取订单数量失败",
                    "fail");
        }

        return returnInformation;
    }

    /**
     * @Description: 封装Order
     * @Param:  封装Order
     * @return: Order
     * @Author: liupeng/刘鹏
     * @Date: 2019-06-04
     * @param order
     * @param resultSet
     * @throws SQLException
     */
    public Order encapsulationOrder(Order order, ResultSet resultSet) throws SQLException {
        order.setOrderID(resultSet.getString("orderID"));
        order.setUserID(resultSet.getString("userID"));
        order.setGoodID(resultSet.getString("goodID"));
        order.setThe_unit_price(resultSet.getDouble("the_unit_price"));
        order.setThe_total_price(resultSet.getDouble("the_total_price"));
        order.setTime(resultSet.getString("time"));
        order.setDate(resultSet.getString("date"));
        return order;
    }
}
