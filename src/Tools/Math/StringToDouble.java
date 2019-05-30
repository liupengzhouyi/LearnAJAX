package Tools.Math;

public class StringToDouble {

    private String strNumber = null;

    private double number;

    public StringToDouble(String strNumber) {
        this.setStrNumber(strNumber);
        this.setNumber(Double.valueOf(this.getStrNumber()));
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
