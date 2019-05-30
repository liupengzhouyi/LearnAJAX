package experiment_9And10.experiment10.user.dao.implement;

import Tools.DateTime.GetDate;
import Tools.DateTime.GetTime;
import Tools.LinkDatabases.SaveData;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.User;
import experiment_9And10.experiment10.user.dao.Interface.operationUser;

import java.sql.SQLException;

public class implementOperationUser implements operationUser {

    @Override
    public ReturnInformation addUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "insert into user(userName, userID, passwordValue, registeredDate, money) " +
                "value (\'" + user.getUserName() + "\', \'" + user.getUserID() + "\', " + user.getPasswordValue() + ", \', " + user.getMoney() + ");";
        SaveData saveData = new SaveData(sql);
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        if (saveData.isKey()) {
            ReturnInformation returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser",
                    "null",
                    "添加用户成功",
                    "success");
        } else {
            ReturnInformation returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser",
                    "原因未知",
                    "添加用户失败",
                    "fail");
        }
        return null;
    }

    @Override
    public ReturnInformation resetUser(User newUser) {
        return null;
    }

    @Override
    public ReturnInformation resetUserPAssword(User newUser) {
        return null;
    }

    @Override
    public ReturnInformation addMoney(String userID, double money) {
        return null;
    }

    @Override
    public ReturnInformation subMoney(String userID, double money) {
        return null;
    }

    @Override
    public ReturnInformation getUserByUserID(String userID) {
        return null;
    }
}
