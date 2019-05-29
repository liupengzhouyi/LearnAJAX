package experiment_1And2.experiment2;

public class User {
    // 用户名
    private String userName;
    // 用户ID
    private String userID;
    // 用户密码值
    private int passwordValue;
    // 用户注册日期
    private String registeredDate;
    // 用户 余额
    private double money;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(int passwordValue) {
        this.passwordValue = passwordValue;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userID='" + userID + '\'' +
                ", passwordValue=" + passwordValue +
                ", registeredDate='" + registeredDate + '\'' +
                ", money=" + money +
                '}';
    }

    public User(String string) {
        if(string.equals("default")) {
            this.setUserID("19001");
            this.setUserName("liupeng");
            this.setPasswordValue("123456".hashCode());
            this.setRegisteredDate("2019-01-02");
            this.setMoney(1000);
        }
    }

    public User() {
    }
}
