package experiment_9And10.experiment10.good.dao.implement;

import Tools.LinkDatabases.GetResultSet;
import Tools.LinkDatabases.SaveData;
import Tools.ReturnInformation.ReturnInformation;
import com.mysql.cj.exceptions.StreamingNotifiable;
import experiment_1And2.experiment2.Good;
import experiment_9And10.experiment10.good.dao.Interface.operationGood;

import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ImplementOperationGood implements operationGood {

    //增加商品
    @Override
    public ReturnInformation addGood(Good good) throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        if(good.equals(null)) {
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.addGood",
                    "传入的商品对象为空",
                    "添加商品失败！",
                    "fail");
        } else {
            sql = "insert into good(goodName, goodPrice, goodRigin, " +
                    "productData, monthNumber, shelvesDate, eliminateKey, eliminateDate) " +
                    "value (\'" + good.getGoodName() + "\', " + good.getGoodPrice() + ", " +
                    "\'" + good.getGoodRigin() + "\', \'" + good.getProductData() + "\', " +
                    good.getMonthNumber() + ", \'" + good.getShelvesDate() + "\', " + good.getEliminateKey() +
                    ", \'" + good.getEliminateDate() + "\');";
            SaveData saveData = new SaveData(sql);
            if (saveData.isKey()) {
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.addGood",
                        "保存数据成功",
                        "添加商品成功！",
                        "success");
            } else {
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.addGood",
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
    public ReturnInformation findAllNotEliminateGood() throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        sql = "select * from good where eliminateKey = 0;";
        GetResultSet getResultSet = new GetResultSet(sql);
        if (getResultSet.isKey()) {
            List<Good> list = new ArrayList<Good>();
            while(getResultSet.getResultSet().next()) {
                String goodID = getResultSet.getResultSet().getString("goodID");
                String goodName = getResultSet.getResultSet().getString("goodName");
                double goodPrice = getResultSet.getResultSet().getDouble("goodPrice");
                String goodRigin = getResultSet.getResultSet().getString("goodRigin");
                String productData = getResultSet.getResultSet().getString("productData");
                int monthNumber = getResultSet.getResultSet().getInt("monthNumber");
                String shelvesDate = getResultSet.getResultSet().getString("shelvesDate");
                int eliminateKey = getResultSet.getResultSet().getInt("eliminateKey");
                String eliminateDate = getResultSet.getResultSet().getString("eliminateDate");
                Good good = new Good();
                good.setGoodID(goodID);
                good.setGoodName(goodName);
                good.setGoodPrice(goodPrice);
                good.setGoodRigin(goodRigin);
                good.setProductData(productData);
                good.setMonthNumber(monthNumber);
                good.setShelvesDate(shelvesDate);
                good.setEliminateKey(eliminateKey);
                good.setEliminateDate(eliminateDate);
                list.add(good);
            }
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.addGood",
                    "null",
                    "获取商品成功！",
                    "success");
            returnInformation.setType("List<Good>");
            returnInformation.setObject(list);
        } else {
            //没有获取
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.addGood",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }
        return returnInformation;
    }
}
