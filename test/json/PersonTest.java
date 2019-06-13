package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    /*
    * jackson 的核心对象
    */
    private ObjectMapper objectMapper = null;

    private Person person = null;

    private String string = null;

    private List<Person> list = null;

    private Map<String, Person> myMap = null;

    public void createObjectMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public void createPerson() {
        person = new Person();
        person.setName("liupeng");
        person.setAge(23);
        person.setSex(false);
        person.setData(new Date());
    }

    public void createList() {
        this.list = new ArrayList<Person>();
    }

    public void createMyMap() {
        this.myMap = new HashMap<String, Person>();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public Map<String, Person> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, Person> myMap) {
        this.myMap = myMap;
    }

    /**
     * 转化方法一
     */
    public void init0() throws IOException {
        this.getObjectMapper().writeValue(new FileWriter(new String("/Users/liupeng/IdeaProjects/LearnAJAX/src/json/text.txt")), this.getPerson());
        /*
        * File : obj to json and save file
        * Writer : obj to json and save 字符输出流
        * OutputStream : obj to json and save to stream
        */
    }
    /**
     * 转化方法二
     */
    public void init1() throws JsonProcessingException {
        // 对象 转 json String
        this.setString(this.getObjectMapper().writeValueAsString(this.getPerson()));
    }

    public void listTo() throws JsonProcessingException {
        this.getList().add(this.getPerson());
        this.getList().add(this.getPerson());
        this.getList().add(this.getPerson());
        this.getList().add(this.getPerson());
        this.getList().add(this.getPerson());
        // 对象 转 json String
        this.setString(this.getObjectMapper().writeValueAsString(this.getList()));
    }

    public void mapTo() throws JsonProcessingException {
        this.getMyMap().put("0", this.getPerson());
        Person person1 = new Person("def");
        this.getMyMap().put("1", this.getPerson());
        Person person2 = new Person("def");
        this.getMyMap().put("2", this.getPerson());
        Person person3 = new Person("def");
        this.getMyMap().put("3", this.getPerson());
        // 对象 转 json String
        this.setString(this.getObjectMapper().writeValueAsString(this.getList()));
    }
    
    public void testMap() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("111", "1");
        map.put("222", "2");
        map.put("333", "3");
        map.put("444", "4");
        // 对象 转 json String
        this.setString(this.getObjectMapper().writeValueAsString(map));
    }

    @BeforeEach
    void setUp() {
        this.createPerson();
        this.createObjectMapper();
        this.createList();
        this.createMyMap();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void paly0() throws IOException {
        this.init0();
    }

    @Test
    void paly1() throws JsonProcessingException {
        this.init1();
        System.out.println(this.getString());
    }


    @Test
    void paly2() throws JsonProcessingException {
        this.listTo();
        System.out.println(this.getString());
    }

    @Test
    void paly3() throws JsonProcessingException {
        this.mapTo();
        System.out.println(this.getString());
    }

    @Test
    void paly4() throws JsonProcessingException {
        this.testMap();
        System.out.println(this.getString());
    }
}