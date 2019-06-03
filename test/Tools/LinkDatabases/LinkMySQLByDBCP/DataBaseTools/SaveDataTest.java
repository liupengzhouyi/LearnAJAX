package Tools.LinkDatabases.LinkMySQLByDBCP.DataBaseTools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SaveDataTest {

    private SaveData saveData = null;

    public SaveData getSaveData() {
        return saveData;
    }

    public void setSaveData(SaveData saveData) {
        this.saveData = saveData;
    }

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        saveData = new SaveData("");
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
    }

    @Test
    void setKey() {
    }

    @Test
    void init() {
    }
}