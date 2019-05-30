package experiment_9And10.experiment10.user.dao.Interface;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.User;

import java.sql.SQLException;

public interface operationUser {

    // 添加用户
    public ReturnInformation addUser(User user) throws SQLException, ClassNotFoundException;

    //修改用户信息
    public ReturnInformation resetUser(User newUser);

    //修改密码
    public ReturnInformation resetUserPAssword(User newUser);

    //充值
    public ReturnInformation addMoney(String userID, double money);

    //消费
    public ReturnInformation subMoney(String userID, double money);

    //获取用户信息
    public ReturnInformation getUserByUserID(String userID);
}
