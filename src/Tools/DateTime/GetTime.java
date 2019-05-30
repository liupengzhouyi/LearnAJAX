package Tools.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {

    private SimpleDateFormat simpleDateFormat = null;

    private Date date = null;

    private String time = null;

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
        this.time = new String();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void init() {
        this.createSimpleDateFormat();
        this.createDate();
    }

    public GetTime() {
        this.init();
        this.getSimpleDateFormat().applyPattern("HH:mm:ss");
        this.setTime(this.getSimpleDateFormat().format(this.getDate()));
    }
}
