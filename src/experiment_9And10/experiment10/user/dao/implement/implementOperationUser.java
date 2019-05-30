package experiment_9And10.experiment10.user.dao.implement;

import Tools.DateTime.GetDate;
import Tools.DateTime.GetTime;
import Tools.LinkDatabases.SaveData;
import Tools.LinkDatabases.UpdateData;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.User;
import experiment_9And10.experiment10.user.dao.Interface.operationUser;

import java.sql.SQLException;

public class implementOperationUser implements operationUser {

    @Override
    public ReturnInformation addUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "insert into user(userName, userID, passwordValue, registeredDate, money) " +
                "value (\'" + user.getUserName() + "\', \'" + user.getUserID() + "\', " + user.getPasswordValue() + ", \', " + user.getMoney() + ");";
        ReturnInformation returnInformation = null;
        SaveData saveData = new SaveData(sql);
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        if (saveData.isKey()) {
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser",
                    "null",
                    "添加用户成功",
                    "success");
        } else {
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser",
                    "原因未知",
                    "添加用户失败",
                    "fail");
        }
        return returnInformation;
    }

    @Override
    public ReturnInformation resetUser(String userID, String newName) throws SQLException, ClassNotFoundException {
        String sql = "update user set user.userName = \'" + newName + "\' where userID = \'" + userID + "\';";
        ReturnInformation returnInformation = null;
        UpdateData updateData = new UpdateData(sql);
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        if (updateData.isKey()) {
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.resetUser()",
                    "null",
                    "重置用户姓名成功",
                    "success");
        } else {
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.resetUser()",
                    "原因未知",
                    "重置用户姓名失败",
                    "fail");
        }
        return returnInformation;
    }

    @Override
    public ReturnInformation resetUserPassword(String userID, String passwordValue) throws SQLException, ClassNotFoundException {
        String sql = "update user set user.passwordValue = \'" + passwordValue + "\' where userID = \'" + userID + "\';";
        ReturnInformation returnInformation = null;
        UpdateData updateData = new UpdateData(sql);
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        if (updateData.isKey()) {
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.resetUserPassword()",
                    "null",
                    "重置用户密码成功",
                    "success");
        } else {
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.resetUserPassword()",
                    "原因未知",
                    "重置用户密码失败",
                    "fail");
        }
        return returnInformation;
    }

    @Override
    public double howMoney(String userID) {
        String sql = "select money from user where userID = \'" + userID + "\';";


        return 0;
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
    public User getUserByUserID(String userID) {


        return null;
    }
}
