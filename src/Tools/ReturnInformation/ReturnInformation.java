package Tools.ReturnInformation;

public class ReturnInformation {

    //时间
    private String time = null;
    //日期
    private String date = null;
    //错误位置
    private String wrongLocation = null;
    //错误信息
    private String massage = null;
    //返回信息
    private String returnInformation = null;
    //结果
    private String result = null;

    public ReturnInformation(String time, String date, String wrongLocation, String massage, String returnInformation, String result) {
        this.time = time;
        this.date = date;
        this.wrongLocation = wrongLocation;
        this.massage = massage;
        this.returnInformation = returnInformation;
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWrongLocation() {
        return wrongLocation;
    }

    public void setWrongLocation(String wrongLocation) {
        this.wrongLocation = wrongLocation;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getReturnInformation() {
        return returnInformation;
    }

    public void setReturnInformation(String returnInformation) {
        this.returnInformation = returnInformation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}