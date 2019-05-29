package experiment_1And2.experiment1;

public class ReadArray {

    private String string = null;

    private String[] strings = null;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void init() {
        this.setStrings(this.getString().split("&"));

    }

    public ReadArray() {
        this.setString("Expression Language&JSTL&Srtvlet过滤器&Servlet监听器&文件上传&文件下载");
        this.init();
    }

    public ReadArray(String string) {
        this.setString(string);
        this.init();
    }
}
