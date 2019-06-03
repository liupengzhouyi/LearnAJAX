package experiment_1And2.experiment2;

public class Order {
    //订单编号
    private String orderID;
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

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID='" + userID + '\'' +
                ", goodID='" + goodID + '\'' +
                ", number=" + number +
                ", the_unit_price=" + the_unit_price +
                ", the_total_price=" + the_total_price +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Order(String string) {
        if (string.equals("default")) {
            this.setOrderID("1");
            this.setGoodID("1");
            this.setUserID("12KJB12312RFVG1");
            this.setNumber(3);
            this.setThe_total_price(12.99);
            this.setThe_unit_price(35.97);
            this.setDate("2019-05-29");
            this.setTime("18:15:34");
        }
    }

    public Order() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
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
