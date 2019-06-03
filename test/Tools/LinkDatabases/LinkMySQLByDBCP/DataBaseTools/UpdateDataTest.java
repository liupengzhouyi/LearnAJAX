package Tools.LinkDatabases.LinkMySQLByDBCP.DataBaseTools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UpdateDataTest {

    private UpdateData updateData = null;

    private String sql = null;

    public UpdateData getUpdateData() {
        return updateData;
    }

    public void setUpdateData(UpdateData updateData) {
        this.updateData = updateData;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        this.setSql("");
        this.updateData = new UpdateData("update user set money = 1234.56 where userID = \'12KJB12312RFVG4\';");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createLinkDatabases() {
    }

    @Test
    void getLinkDatabases() {
    }

    @Test
    void setLinkDatabases() {
    }

    @Test
    void createSQL() {
    }

    @Test
    void getSql() {
    }

    @Test
    void setSql() {
    }

    @Test
    void isKey() {
        System.out.println(this.getUpdateData().isKey());
    }

    @Test
    void setKey() {
    }

    @Test
    void init() {
    }
}