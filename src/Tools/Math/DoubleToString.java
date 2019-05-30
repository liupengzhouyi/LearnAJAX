package Tools.Math;

public class DoubleToString {

    private double number;

    private String strDouble = null;

    public DoubleToString(double number) {
        this.setNumber(number);
        this.setStrDouble(this.getNumber() + "");
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getStrDouble() {
        return strDouble;
    }

    public void setStrDouble(String strDouble) {
        this.strDouble = strDouble;
    }
}
