package Tools.Math;

public class StringToDouble {

    private String strNumber = null;

    private double number;

    private String integerNumber;

    private String decimalNumber;

    public StringToDouble(String strNumber) {
        this.setStrNumber(strNumber);
        System.out.println(strNumber);
        String[] strings = this.getStrNumber().split("\\.");
        System.out.println("strings.length:" + strings.length);
        if (strings.length == 2) {
            this.setIntegerNumber(strings[0]);
            this.setDecimalNumber(strings[1]);
        } else {
            this.setIntegerNumber("0");
            this.setDecimalNumber("0");
        }
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
        int temp = Integer.getInteger(this.decimalNumber);
        double tempNumber = 0.0 + temp;
        int length = this.decimalNumber.length();
        double myDivisor = 1;
        for (int i=0;i<length;i++) {
            myDivisor = myDivisor * 10;
        }
        double number = tempNumber / myDivisor;
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
