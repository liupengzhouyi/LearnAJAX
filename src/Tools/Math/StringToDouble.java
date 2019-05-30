package Tools.Math;

public class StringToDouble {

    private String strNumber = null;

    private double number;

    private String integerNumber;

    private String decimalNumber;

    public StringToDouble(String strNumber) {
        this.setStrNumber(strNumber);
        String integerNumber = this.getStrNumber().split(".")[0];
        this.setIntegerNumber(integerNumber);
        String decimalNumber = this.getStrNumber().split(".")[1];
        this.setDecimalNumber(decimalNumber);
        this.setNumber(this.getIntegerNumber() + this.getDecimalNumber());
    }

    public double getIntegerNumber() {
        int tempNumber = Integer.getInteger(this.integerNumber);
        double number = 0.0 + tempNumber;
        return number;
    }

    public void setIntegerNumber(String integerNumber) {
        this.integerNumber = integerNumber;
    }

    public double getDecimalNumber() {
        int tempNumber = Integer.getInteger(this.decimalNumber);
        int length = this.decimalNumber.length();
        double divisor = 1;
        for (int i=0;i<length;i++) {
            divisor = divisor * 10;
        }
        double number = tempNumber / divisor;
        return number;
    }

    public void setDecimalNumber(String decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public String getStrNumber() {
        return strNumber;
    }

    public void setStrNumber(String strNumber) {
        this.strNumber = strNumber;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
