package experiment_9And10.experiment10.user.dao.Interface;

import experiment_1And2.experiment2.User;

import java.sql.SQLException;

public interface operationUser {

    // 添加用户
    public void addUser(User user) throws SQLException, ClassNotFoundException;

    //修改用户信息
    public void resetUser(User newUser);

    //修改密码
    public void resetUserPAssword(User newUser);

    //充值
    public void addMoney(String userID, double money);

    //消费
    public void subMoney(String userID, double money);

    //获取用户信息
    public void getUserByUserID(String userID);
}
