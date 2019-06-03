package Tools.LinkDatabases.LinkMySQLByDBCP;

import Tools.LinkDatabases.LinkMySQLByDBCP.AbandonedTools.MySQLUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MySQLUtilTest {

    private MySQLUtil mySQLUtil = null;

    private String MySQLlink = "java:comp/env/jdbc/javaDatabase";

    public MySQLUtil getMySQLUtil() {
        return mySQLUtil;
    }

    public void setMySQLUtil(MySQLUtil mySQLUtil) {
        this.mySQLUtil = mySQLUtil;
    }

    public String getMySQLlink() {
        return MySQLlink;
    }

    public void setMySQLlink(String mySQLlink) {
        MySQLlink = mySQLlink;
    }

    @BeforeEach
    void setUp() {
        this.mySQLUtil = new MySQLUtil(this.getMySQLlink());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setDataSourceName() {
    }

    @Test
    void init() {
        this.getMySQLUtil().init();
    }

    @Test
    void update() {
    }

    @Test
    void query() {
    }
}