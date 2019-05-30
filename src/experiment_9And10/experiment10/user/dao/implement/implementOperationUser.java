package experiment_9And10.experiment10.user.dao.implement;

import Tools.LinkDatabases.SaveData;
import experiment_1And2.experiment2.User;
import experiment_9And10.experiment10.user.dao.Interface.operationUser;

import java.sql.SQLException;

public class implementOperationUser implements operationUser {

    @Override
    public void addUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "insert into user(userName, userID, passwordValue, registeredDate, money) " +
                "value (\'" + user.getUserName() + "\', \'" + user.getUserID() + "\', " + user.getPasswordValue() + ", \', " + user.getMoney() + ");";
        SaveData saveData = new SaveData(sql);
    }

    @Override
    public void resetUser(User newUser) {

    }

    @Override
    public void resetUserPAssword(User newUser) {

    }

    @Override
    public void addMoney(String userID, double money) {

    }

    @Override
    public void subMoney(String userID, double money) {

    }

    @Override
    public void getUserByUserID(String userID) {

    }
}
