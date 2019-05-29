package experiment_1And2.experiment2;

public class Order {
    //订单编号
    private int orderID;
    //用户编号
    private String userID = null;
    //商品编号
    private String goodID = null;
    //商品数量
    private int number;
    //单价
    private double the_unit_price;
    //总价
    private double the_total_price;
    //日期
    private String date = null;
    //时间
    private String time = null;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGoodID() {
        return goodID;
    }

    public void setGoodID(String goodID) {
        this.goodID = goodID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getThe_unit_price() {
        return the_unit_price;
    }

    public void setThe_unit_price(double the_unit_price) {
        this.the_unit_price = the_unit_price;
    }

    public double getThe_total_price() {
        return the_total_price;
    }

    public void setThe_total_price(double the_total_price) {
        this.the_total_price = the_total_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
