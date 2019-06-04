package experiment_11And12.experiment11;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class GetMaxPagingTest {

    private GetMaxPaging getMaxPaging = null;

    public GetMaxPaging getGetMaxPaging() {
        return getMaxPaging;
    }

    public void setGetMaxPaging(GetMaxPaging getMaxPaging) {
        this.getMaxPaging = getMaxPaging;
    }

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        this.getMaxPaging = new GetMaxPaging();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getmaxPaging() {
        System.out.println(this.getGetMaxPaging().getmaxPaging());
    }
}