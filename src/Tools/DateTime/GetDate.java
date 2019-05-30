package Tools.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

    private SimpleDateFormat simpleDateFormat = null;

    private Date date = null;

    private String string = null;

    public void createSimpleDateFormat() {
        this.simpleDateFormat = new SimpleDateFormat();
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public void createDate() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void createString() {
        this.string = new String();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void init() {
        this.createSimpleDateFormat();
        this.createDate();
    }

    public GetDate() {
        this.init();
        this.getSimpleDateFormat().applyPattern("yyyy-MM-dd");
        //yyyy-MM-dd HH:mm:ss
        this.setString(this.getSimpleDateFormat().format(this.getDate()));
    }

}
