package experiment_9And10.experiment10.good.dao.implement;

import Tools.LinkDatabases.LinkMySQLByJDBC.GetResultSet;
import Tools.LinkDatabases.LinkMySQLByJDBC.SaveData;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_9And10.experiment10.good.dao.Interface.OperationGood;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementOperationGood implements OperationGood {

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

    @Override
    public ReturnInformation goodIsExistence(String goodID) throws SQLException, ClassNotFoundException {
        ReturnInformation returnInformation = null;
        if (!goodID.isEmpty()) {
            String sql = "select * from good where goodID = " + goodID + ";";
            GetResultSet getResultSet = new GetResultSet(sql);

            if (getResultSet.isKey()) {
                while(getResultSet.getResultSet().next()) {
                    String ID = getResultSet.getResultSet().getString("goodID");
                    if (ID.equals(goodID)) {
                        returnInformation = new ReturnInformation(
                                "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.goodIsExistence",
                                "从数据库中获取数据",
                                "商品存在",
                                "success");
                    }
                }
            } else {
                System.out.println("-----------------------------");
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.goodIsExistence",
                        "从数据库中获取数据失败",
                        "获取商品失败",
                        "fail");
            }
        } else {
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.goodIsExistence",
                    "参数传入失败，没有接受到商品ID",
                    "获取商品失败",
                    "fail");
        }
        return returnInformation;
    }

    @Override
    public ReturnInformation findGoodByGoodID(String goodID) throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        sql = "select * from good where goodID = " + goodID + ";";
        GetResultSet getResultSet = new GetResultSet(sql);
        if (getResultSet.isKey()) {
            Good good = null;
            while(getResultSet.getResultSet().next()) {
                good = new Good();
                good.setGoodID(getResultSet.getResultSet().getString("goodID"));
                good.setGoodName(getResultSet.getResultSet().getString("goodName"));
                good.setGoodPrice(getResultSet.getResultSet().getDouble("goodPrice"));
                good.setGoodRigin(getResultSet.getResultSet().getString("goodRigin"));
                good.setProductData(getResultSet.getResultSet().getString("productData"));
                good.setMonthNumber(getResultSet.getResultSet().getInt("monthNumber"));
                good.setShelvesDate(getResultSet.getResultSet().getString("shelvesDate"));
                good.setEliminateKey(getResultSet.getResultSet().getInt("eliminateKey"));
                good.setEliminateDate(getResultSet.getResultSet().getString("eliminateDate"));
            }
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.findGoodByGoodID",
                    "null",
                    "获取商品成功！",
                    "success");
            returnInformation.setType("good");
            returnInformation.setObject(good);
        } else {
            //没有获取
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.findGoodByGoodID",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }
        return returnInformation;
    }
}
