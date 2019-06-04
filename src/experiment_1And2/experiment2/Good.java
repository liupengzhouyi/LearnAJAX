package experiment_1And2.experiment2;

/**
 * @author liupeng
 */
public class Good {

    /**
     * 商品编号
     */
    private String goodID = null;
    // 商品原产地
    private String goodRigin = null;
    // 商品价格
    private double goodPrice = -0.1;
    // 商品名称
    private String goodName = null;
    // 上架日期
    private String shelvesDate = null;
    // 保质期
    private int monthNumber = -1;
    // 生产日期
    private String productData = null;
    // 下架日期
    private String eliminateDate = null;
    // 是否下架
    private int eliminateKey = 0;

    public String getGoodID() {
        return goodID;
    }

    public void setGoodID(String goodID) {
        this.goodID = goodID;
    }

    public String getGoodRigin() {
        return goodRigin;
    }

    public void setGoodRigin(String goodRigin) {
        this.goodRigin = goodRigin;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getShelvesDate() {
        return shelvesDate;
    }

    public void setShelvesDate(String shelvesDate) {
        this.shelvesDate = shelvesDate;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getProductData() {
        return productData;
    }

    public void setProductData(String productData) {
        this.productData = productData;
    }

    public String getEliminateDate() {
        return eliminateDate;
    }

    public void setEliminateDate(String eliminateDate) {
        this.eliminateDate = eliminateDate;
    }

    public int getEliminateKey() {
        return eliminateKey;
    }

    public void setEliminateKey(int eliminateKey) {
        this.eliminateKey = eliminateKey;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodID='" + goodID + '\'' +
                ", goodRigin='" + goodRigin + '\'' +
                ", goodPrice=" + goodPrice +
                ", goodName='" + goodName + '\'' +
                ", shelvesDate='" + shelvesDate + '\'' +
                ", monthNumber=" + monthNumber +
                ", productData='" + productData + '\'' +
                ", eliminateDate='" + eliminateDate + '\'' +
                ", eliminateKey=" + eliminateKey +
                '}';
    }

    public Good(String string) {
        if (string.equals("default")) {
            this.setGoodID("1");
            this.setGoodName("巧克力");
            this.setGoodPrice(12.99);
            this.setGoodRigin("美国");
            this.setProductData("2018-12-01");
            this.setMonthNumber(36);
            this.setShelvesDate("2021-12-01");
            this.setEliminateDate("null");
            this.setEliminateKey(0);
        }
    }

    public Good() {
    }
}
