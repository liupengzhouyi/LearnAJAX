package Tools.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateTime {

    private SimpleDateFormat simpleDateFormat = null;

    private Date date = null;

    private String dateTime = null;

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

    public void createDateTime() {
        this.dateTime = new String();
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void init() {
        this.createSimpleDateFormat();
        this.createDate();
        this.createDateTime();
    }

    public GetDateTime() {
        this.init();
        this.getSimpleDateFormat().applyPattern("yyyy-MM-dd HH:mm:ss");
        this.setDateTime(this.getSimpleDateFormat().format(this.getDate()));
    }
}
