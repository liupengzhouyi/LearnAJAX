package experiment_9And10.experiment10.good.dao.implement;

import experiment_1And2.experiment2.Good;
import experiment_9And10.experiment10.good.dao.Interface.operationGood;

import java.util.List;

public class implementOperationGood implements operationGood {

    @Override
    public void addGood(Good good) {

    }

    @Override
    public void resetGood(Good newGood) {

    }

    @Override
    public void resetGoodPrice(String goodID, String newPrice) {

    }

    @Override
    public void eliminateGood(String goodID) {

    }

    @Override
    public List<Good> findAllGood() {
        return null;
    }

    @Override
    public List<Good> findAllEliminateGood() {
        return null;
    }

    @Override
    public List<Good> findAllNotEliminateGood() {
        return null;
    }
}
