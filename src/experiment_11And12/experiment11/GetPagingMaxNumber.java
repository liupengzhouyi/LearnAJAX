package experiment_11And12.experiment11;

public class GetPagingMaxNumber {

    private static int MAXPAGINGNUMBER = 7;

    private int number = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public GetPagingMaxNumber(int number) {
        this.number = number;
    }

    public GetPagingMaxNumber() {
        this.number = MAXPAGINGNUMBER;
    }
}
