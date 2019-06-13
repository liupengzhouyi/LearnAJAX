package json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


public class Person {

    private String name;

    private int age;

    private boolean sex;

    private Date date;

    //@JsonIgnore

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    // 格式化输出
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getData() {
        return date;
    }

    public void setData(Date data) {
        this.date = data;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", date=" + date +
                '}';
    }

    public Person() {
    }

    public Person(String string) {
        if (string.equals("def")) {
            this.setName("liupeng");
            this.setAge(23);
            this.setSex(false);
            this.setData(new Date());
        }
    }
}
