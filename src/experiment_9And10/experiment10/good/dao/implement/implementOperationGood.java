package experiment_9And10.experiment10.good.dao.implement;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_9And10.experiment10.good.dao.Interface.operationGood;

import java.util.List;

public class implementOperationGood implements operationGood {

    //增加商品
    @Override
    public ReturnInformation addGood(Good good) {
        return null;
    }

    //修改商品信息
    @Override
    public ReturnInformation resetGood(Good newGood) {
        return null;
    }

    //修改价格
    @Override
    public ReturnInformation resetGoodPrice(String goodID, String newPrice) {
        return null;
    }

    //下架商品
    @Override
    public ReturnInformation eliminateGood(String goodID) {
        return null;
    }

    //查找所有商品
    @Override
    public ReturnInformation findAllGood() {
        return null;
    }

    //查找所有下架商品
    @Override
    public ReturnInformation findAllEliminateGood() {
        return null;
    }

    //查找所有没有下架商品
    @Override
    public ReturnInformation findAllNotEliminateGood() {
        return null;
    }
}
