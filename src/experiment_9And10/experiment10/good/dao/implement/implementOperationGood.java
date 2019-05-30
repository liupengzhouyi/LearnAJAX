package experiment_9And10.experiment10.good.dao.implement;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_9And10.experiment10.good.dao.Interface.operationGood;

import java.util.List;

public class implementOperationGood implements operationGood {

    @Override
    public ReturnInformation addGood(Good good) {
        return null;
    }

    @Override
    public ReturnInformation resetGood(Good newGood) {
        return null;
    }

    @Override
    public ReturnInformation resetGoodPrice(String goodID, String newPrice) {
        return null;
    }

    @Override
    public ReturnInformation eliminateGood(String goodID) {
        return null;
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
