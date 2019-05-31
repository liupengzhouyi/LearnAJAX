package experiment_9And10.experiment10.good.dao.implement;

import Tools.LinkDatabases.SaveData;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_9And10.experiment10.good.dao.Interface.operationGood;

import java.sql.SQLException;
import java.util.List;

public class implementOperationGood implements operationGood {

    //增加商品
    @Override
    public ReturnInformation addGood(Good good) throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        if(good.equals(null)) {
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.implementOperationGood.addGood",
                    "传入的商品对象为空",
                    "添加商品失败！",
                    "fail");
        } else {
            sql = "insert into good(goodID, goodName, goodPrice, goodRigin, " +
                    "productData, monthNumber, shelvesDate, eliminateKey, eliminateDate) " +
                    "value (1, \'" + good.getGoodName() + "\', " + good.getGoodPrice() + ", " +
                    "\'" + good.getGoodRigin() + "\', \'" + good.getProductData() + "\', " +
                    good.getMonthNumber() + ", \'" + good.getShelvesDate() + "\', " + good.getEliminateKey() +
                    ", \'" + good.getEliminateDate() + "\');";
            SaveData saveData = new SaveData(sql);
            if (saveData.isKey()) {
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.good.dao.implement.implementOperationGood.addGood",
                        "保存数据成功",
                        "添加商品成功！",
                        "success");
            } else {
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.good.dao.implement.implementOperationGood.addGood",
                        "保存数据失败",
                        "添加商品失败！",
                        "fail");
            }

        }

        return returnInformation;
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
