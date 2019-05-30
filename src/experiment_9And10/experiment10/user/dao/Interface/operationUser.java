package experiment_9And10.experiment10.user.dao.Interface;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.User;

import java.sql.SQLException;

public interface operationUser {

    // 添加用户
    public ReturnInformation addUser(User user) throws SQLException, ClassNotFoundException;

    //修改用户名
    public ReturnInformation resetUser(String userID, String newName) throws SQLException, ClassNotFoundException;

    //修改密码
    public ReturnInformation resetUserPassword(String userID, String passwordValue) throws SQLException, ClassNotFoundException;

    //查询余额
    public ReturnInformation howMoney(String userID) throws SQLException, ClassNotFoundException;

    //充值
    public ReturnInformation addMoney(String userID, double money) throws SQLException, ClassNotFoundException;

    //消费
    public ReturnInformation subMoney(String userID, double money) throws SQLException, ClassNotFoundException;

    //获取用户信息
    public ReturnInformation getUserByUserID(String userID) throws SQLException, ClassNotFoundException;
}
