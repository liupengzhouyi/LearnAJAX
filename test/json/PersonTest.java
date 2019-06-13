package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    /*
    * jackson 的核心对象
    */
    private ObjectMapper objectMapper = null;

    private Person person = null;

    private String string = null;

    public void createObjectMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public void createPerson() {
        person = new Person();
        person.setName("liupeng");
        person.setAge(23);
        person.setSex(false);
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

    @BeforeEach
    void setUp() {
        this.createPerson();
        this.createObjectMapper();
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
}