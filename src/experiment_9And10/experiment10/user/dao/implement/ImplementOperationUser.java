package experiment_9And10.experiment10.user.dao.implement;

import Tools.DateTime.GetDate;
import Tools.DateTime.GetTime;
import Tools.LinkDatabases.LinkMySQLByJDBC.GetResultSet;
import Tools.LinkDatabases.LinkMySQLByJDBC.SaveData;
import Tools.LinkDatabases.LinkMySQLByJDBC.UpdateData;
import Tools.Math.StringToDouble;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.User;
import experiment_9And10.experiment10.user.dao.Interface.operationUser;

import java.sql.SQLException;

public class ImplementOperationUser implements operationUser {

    @Override
    public ReturnInformation addUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "insert into user(userName, userID, passwordValue, registeredDate, money) " +
                "value (\'" + user.getUserName() + "\', \'" + user.getUserID() + "\', " + user.getPasswordValue() + ", \'" + user.getRegisteredDate() + "\', " + user.getMoney() + ");";
        //System.out.println(sql);
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
        UpdateData updateData = new UpdateData(sql);
        ReturnInformation returnInformation = null;
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
    public ReturnInformation howMoney(String userID) throws SQLException, ClassNotFoundException {
        String sql = "select money from user where userID = \'" + userID + "\';";
        GetResultSet getResultSet = new GetResultSet(sql);
        ReturnInformation returnInformation = null;
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        if(getResultSet.isKey()) {
            String money = "null";
            while(getResultSet.getResultSet().next()) {
                money = getResultSet.getResultSet().getString("money");
            }
            if (money.equals("null")) {
                returnInformation = new ReturnInformation(getTime.getTime(), getDate.getMyDaye(), "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.howMoney()", "原因未知", "查询用户\" + userID + \"失败", "fail");
            } else {
                returnInformation = new ReturnInformation(getTime.getTime(), getDate.getMyDaye(), "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.howMoney()", "null", "查询用户" + userID + "成功", "success");
                returnInformation.setType("double");
                returnInformation.setObject(money);
            }
        } else {
            returnInformation = new ReturnInformation(getTime.getTime(), getDate.getMyDaye(), "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.howMoney()", "原因未知", "查询用户\" + userID + \"失败", "fail");
        }
        return returnInformation;
    }

    @Override
    public ReturnInformation addMoney(String userID, double money) throws SQLException, ClassNotFoundException {
        ReturnInformation moneyInformation = this.howMoney(userID);
        ReturnInformation returnInformation = null;
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        if (moneyInformation.getResult().equals("success")) {
            String myMoney = (String) moneyInformation.getObject();
            StringToDouble stringToDouble = new StringToDouble(myMoney);
            double newMoney = stringToDouble.getNumber() + money;
            String sql = "update user set user.money = " +newMoney + " where userID = \'" + userID + "\';";
            UpdateData updateData = new UpdateData(sql);
            if (updateData.isKey()) {
                returnInformation = new ReturnInformation(
                        getTime.getTime(),
                        getDate.getMyDaye(),
                        "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.addMoney()",
                        "null",
                        "充值成功",
                        "success");
            } else {
                returnInformation = new ReturnInformation(
                        getTime.getTime(),
                        getDate.getMyDaye(),
                        "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.addMoney()",
                        "原因未知",
                        "充值失败",
                        "fail");
            }
        } else {
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.addMoney()",
                    "原因未知",
                    "查询余额失败",
                    "fail");
        }
        return returnInformation;
    }

    @Override
    public ReturnInformation subMoney(String userID, double money) throws SQLException, ClassNotFoundException {
        ReturnInformation moneyInformation = this.howMoney(userID);
        ReturnInformation returnInformation = null;
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        if (moneyInformation.getResult().equals("success")) {
            String myMoney = (String) moneyInformation.getObject();
            StringToDouble stringToDouble = new StringToDouble(myMoney);
            double newMoney = stringToDouble.getNumber() - money;
            if(newMoney < 0) {
                //余额不足
                returnInformation = new ReturnInformation(
                        getTime.getTime(),
                        getDate.getMyDaye(),
                        "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.addMoney()",
                        "原因未知",
                        "余额不足",
                        "fail");
            } else {
                //余额充足，可以消费
                String sql = "update user set user.money = " +newMoney + " where userID = \'" + userID + "\';";
                UpdateData updateData = new UpdateData(sql);
                if (updateData.isKey()) {
                    returnInformation = new ReturnInformation(
                            getTime.getTime(),
                            getDate.getMyDaye(),
                            "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.subMoney()",
                            "null",
                            "消费成功",
                            "success");
                } else {
                    returnInformation = new ReturnInformation(
                            getTime.getTime(),
                            getDate.getMyDaye(),
                            "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.subMoney()",
                            "原因未知",
                            "消费失败",
                            "fail");
                }
            }
        } else {
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.addMoney()",
                    "原因未知",
                    "查询余额失败",
                    "fail");
        }
        return returnInformation;
    }

    @Override
    public ReturnInformation getUserByUserID(String userID) throws SQLException, ClassNotFoundException {
        String sql = "select * from user where userID = \'" + userID + "\';";
        ReturnInformation returnInformation = null;
        GetResultSet getResultSet = new GetResultSet(sql);
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        User user = null;
        if (getResultSet.isKey()) {
            while(getResultSet.getResultSet().next()) {
                String mysql_userName = getResultSet.getResultSet().getString("userName");
                String mysql_userID = getResultSet.getResultSet().getString("userID");
                int mysql_passwordValue = getResultSet.getResultSet().getInt("passwordValue");
                String mysql_registeredDate = getResultSet.getResultSet().getString("registeredDate");
                String mysql_money = getResultSet.getResultSet().getString("money");
                user = new User();
                user.setUserID(mysql_userID);
                user.setUserName(mysql_userName);
                user.setPasswordValue(mysql_passwordValue);
                user.setRegisteredDate(mysql_registeredDate);
                user.setMoney(new StringToDouble(mysql_money).getNumber());
            }
            if (user.equals(null)) {
                // 没有查询到
                returnInformation = new ReturnInformation(
                        getTime.getTime(),
                        getDate.getMyDaye(),
                        "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.getUserByUserID()",
                        "原因未知",
                        "查询用户失败！",
                        "fail");
            } else {
                returnInformation = new ReturnInformation(
                        getTime.getTime(),
                        getDate.getMyDaye(),
                        "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.getUserByUserID()",
                        "null",
                        "查询用户成功",
                        "success");
                returnInformation.setType("User");
                returnInformation.setObject(user);
            }
        } else {
            //查询失败，没有该用户
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.getUserByUserID()",
                    "原因未知",
                    "查询用户失败！",
                    "fail");
        }
        return returnInformation;
    }

    @Override
    public ReturnInformation landing(String userID, String password) throws SQLException, ClassNotFoundException {
        String sql = "select passwordValue from user where userID = \'" + userID + "\';";
        ReturnInformation returnInformation = null;
        GetResultSet getResultSet = new GetResultSet(sql);
        GetDate getDate = new GetDate();
        GetTime getTime = new GetTime();
        if(getResultSet.isKey()) {
            String yourPasword = "rxdcfvgbhnjjmfh";
            while(getResultSet.getResultSet().next()) {
                yourPasword = getResultSet.getResultSet().getString("passwordValue");
            }
            if (password.equals(yourPasword)) {
                //登陆成功！
                returnInformation = new ReturnInformation(
                        getTime.getTime(),
                        getDate.getMyDaye(),
                        "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.getUserByUserID()",
                        "null",
                        "登陆成功",
                        "success");
            } else {
                // 密码错误！
                returnInformation = new ReturnInformation(
                        getTime.getTime(),
                        getDate.getMyDaye(),
                        "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.landing()",
                        "密码错误",
                        "登陆失败",
                        "fail");
            }

        } else {
            //没有该用户ID
            //查询失败，没有该用户
            returnInformation = new ReturnInformation(
                    getTime.getTime(),
                    getDate.getMyDaye(),
                    "experiment_9And10.experiment10.user.dao.implement.implementOperationUser.landing()",
                    "没有该用户ID",
                    "登陆失败",
                    "fail");
        }
        return returnInformation;
    }
}
