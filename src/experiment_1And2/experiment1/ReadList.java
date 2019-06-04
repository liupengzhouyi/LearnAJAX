package experiment_1And2.experiment1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupeng
 */
public class ReadList {

    private String string = null;

    private List<String> list = null;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    private void initList() {
        this.list = new ArrayList<String>();
    }

    public void init() {
        this.initList();
        String[] strings = this.getString().split("&");
        for (String str : strings) {
            this.getList().add(str);
        }
    }

    public ReadList() {
        this.setString("Expression Language&JSTL&Srtvlet过滤器&Servlet监听器&文件上传&文件下载");
        this.init();
    }

    public ReadList(String string) {
        this.string = string;
        this.init();
    }
}
