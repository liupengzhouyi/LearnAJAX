package experiment_11And12.experiment11;

import Tools.ReturnInformation.ReturnInformation;
import experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder;

import java.sql.SQLException;

public class GetMaxPaging {

    private int maxPaging = 0;

    public int getmaxPaging() {
        return maxPaging;
    }

    private void setmaxPaging(int maxPaging) {
        this.maxPaging = maxPaging;
    }

    public void init() throws SQLException, ClassNotFoundException {
        int maxPaging = new GetPagingMaxNumber().getNumber();
        ImplementOperationOrder implementOperationOrder = new ImplementOperationOrder();
        ReturnInformation returnInformation = implementOperationOrder.ordersumber();
        int number = (int) returnInformation.getObject();
        this.setmaxPaging(number/maxPaging);
    }
    
    public GetMaxPaging() throws SQLException, ClassNotFoundException {
        init();
    }
}
