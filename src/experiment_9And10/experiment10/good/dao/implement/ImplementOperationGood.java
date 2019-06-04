package experiment_9And10.experiment10.good.dao.implement;

import Tools.DateTime.GetDate;
import Tools.DateTime.GetDateTime;
import Tools.LinkDatabases.LinkMySQLByJDBC.DataBaseTools.GetResultSet;
import Tools.LinkDatabases.LinkMySQLByJDBC.DataBaseTools.SaveData;
import Tools.LinkDatabases.LinkMySQLByJDBC.DataBaseTools.UpdateData;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_9And10.experiment10.good.dao.Interface.OperationGood;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementOperationGood implements OperationGood {

    /**
     * 增加商品
     * @param good
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * 修改商品信息
     * @param newGood
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation resetGood(Good newGood) throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        if(newGood == null) {
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGood",
                    "传入的商品对象为空",
                    "修改商品失败！",
                    "fail");
        } else {
            returnInformation = this.goodIsExistence(Integer.valueOf(newGood.getGoodID()) + "");
            if (returnInformation.getResult().equals("success")) {
                //商品存在
                sql = "update good set " +
                        "goodName = \'" + newGood.getGoodName() + "\', " +
                        "goodPrice = " + newGood.getGoodPrice() + ", " +
                        "goodRigin = \'" + newGood.getGoodRigin() + "\', " +
                        "productData = \'" + newGood.getProductData() + "\', " +
                        "monthNumber = " + newGood.getMonthNumber() + ", " +
                        "shelvesDate = \'" + newGood.getShelvesDate() + "\', " +
                        "eliminateKey = " + newGood.getEliminateKey() + ", " +
                        "eliminateDate = \'" + newGood.getEliminateDate() + "\' " +
                        "where goodID = " + newGood.getGoodID() + ";";
                UpdateData updateData = new UpdateData(sql);
                if (updateData.isKey()) {
                    returnInformation = new ReturnInformation(
                            "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.addGood",
                            "修改数据成功",
                            "修改商品成功！",
                            "success");
                } else {
                    returnInformation = new ReturnInformation(
                            "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.addGood",
                            "修改数据失败",
                            "修改数据出错！",
                            "fail");
                }
            } else {
                //商品不存在
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGood",
                        "修改数据失败",
                        "修改商品失败！",
                        "fail");
            }
        }
        return returnInformation;
    }

    /**
     * 修改价格
     * @param goodID
     * @param newPrice
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation resetGoodPrice(String goodID, String newPrice) throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        if(goodID.equals(null)||newPrice.equals(null)) {
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGoodPrice",
                    "传入的对象为空",
                    "修改商品失败！",
                    "fail");
        } else {
            returnInformation = this.goodIsExistence(goodID);
            if (returnInformation.getResult().equals("success")) {
                //商品存在
                sql = "update good set goodPrice = " + goodID + " where goodID = " + newPrice + ";";
                UpdateData updateData = new UpdateData(sql);
                if (updateData.isKey()) {
                    returnInformation = new ReturnInformation(
                            "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGoodPrice",
                            "修改数据成功",
                            "修改商品成功！",
                            "success");
                } else {
                    returnInformation = new ReturnInformation(
                            "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGoodPrice",
                            "修改数据失败",
                            "修改数据出错！",
                            "fail");
                }
            } else {
                //商品不存在
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGoodPrice",
                        "修改数据失败",
                        "修改商品失败！",
                        "fail");
            }
        }
        return returnInformation;
    }

    /**
     * 下架商品
     * @param goodID
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation eliminateGood(String goodID) throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        if(goodID.equals(null)) {
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGoodPrice",
                    "传入的对象为空",
                    "修改商品失败！",
                    "fail");
        } else {
            returnInformation = this.goodIsExistence(goodID);
            if (returnInformation.getResult().equals("success")) {
                //商品存在
                sql = "update good set eliminateKey = 1, eliminateDate = \'" + new GetDate().getMyDaye() + "\' where goodID = " + goodID + ";";
                UpdateData updateData = new UpdateData(sql);
                if (updateData.isKey()) {
                    returnInformation = new ReturnInformation(
                            "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGoodPrice",
                            "修改数据成功",
                            "修改商品成功！",
                            "success");
                } else {
                    returnInformation = new ReturnInformation(
                            "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGoodPrice",
                            "修改数据失败",
                            "修改数据出错！",
                            "fail");
                }
            } else {
                //商品不存在
                returnInformation = new ReturnInformation(
                        "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.resetGoodPrice",
                        "修改数据失败",
                        "修改商品失败！",
                        "fail");
            }
        }
        return returnInformation;
    }

    /**
     * 查找所有商品
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation findAllGood() throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        sql = "select * from good;";
        GetResultSet getResultSet = new GetResultSet(sql);
        if (getResultSet.isKey()) {
            List<Good> list = new ArrayList<Good>();
            while(getResultSet.getResultSet().next()) {
                Good good = new Good();
                good.setGoodID(getResultSet.getResultSet().getString("goodID"));
                good.setGoodName(getResultSet.getResultSet().getString("goodName"));
                good.setGoodPrice(getResultSet.getResultSet().getDouble("goodPrice"));
                good.setGoodRigin(getResultSet.getResultSet().getString("goodRigin"));
                good.setProductData(getResultSet.getResultSet().getString("productData"));
                good.setMonthNumber(getResultSet.getResultSet().getInt("monthNumber"));
                good.setShelvesDate(getResultSet.getResultSet().getString("shelvesDate"));
                good.setEliminateKey(getResultSet.getResultSet().getInt("eliminateKey"));
                good.setEliminateDate(getResultSet.getResultSet().getString("eliminateDate"));
                list.add(good);
            }
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.findAllEliminateGood",
                    "null",
                    "获取商品成功！",
                    "success");
            returnInformation.setType("List<Good>");
            returnInformation.setObject(list);
        } else {
            //没有获取
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.findAllEliminateGood",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }
        return returnInformation;
    }


    /**
     * 查找所有下架商品
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation findAllEliminateGood() throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        sql = "select * from good where eliminateKey = 1;";
        GetResultSet getResultSet = new GetResultSet(sql);
        if (getResultSet.isKey()) {
            List<Good> list = new ArrayList<Good>();
            while(getResultSet.getResultSet().next()) {
                Good good = new Good();
                good.setGoodID(getResultSet.getResultSet().getString("goodID"));
                good.setGoodName(getResultSet.getResultSet().getString("goodName"));
                good.setGoodPrice(getResultSet.getResultSet().getDouble("goodPrice"));
                good.setGoodRigin(getResultSet.getResultSet().getString("goodRigin"));
                good.setProductData(getResultSet.getResultSet().getString("productData"));
                good.setMonthNumber(getResultSet.getResultSet().getInt("monthNumber"));
                good.setShelvesDate(getResultSet.getResultSet().getString("shelvesDate"));
                good.setEliminateKey(getResultSet.getResultSet().getInt("eliminateKey"));
                good.setEliminateDate(getResultSet.getResultSet().getString("eliminateDate"));
                list.add(good);
            }
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.findAllEliminateGood",
                    "null",
                    "获取商品成功！",
                    "success");
            returnInformation.setType("List<Good>");
            returnInformation.setObject(list);
        } else {
            //没有获取
            returnInformation = new ReturnInformation(
                    "experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood.findAllEliminateGood",
                    "没有商品",
                    "获取商品失败！",
                    "fail");
        }
        return returnInformation;
    }

    /**
     * 查找所有没有下架商品
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ReturnInformation findAllNotEliminateGood() throws SQLException, ClassNotFoundException {
        String sql = null;
        ReturnInformation returnInformation = null;
        sql = "select * from good where eliminateKey = 0;";
        GetResultSet getResultSet = new GetResultSet(sql);
        if (getResultSet.isKey()) {
            List<Good> list = new ArrayList<Good>();
            while(getResultSet.getResultSet().next()) {
                Good good = new Good();
                good.setGoodID(getResultSet.getResultSet().getString("goodID"));
                good.setGoodName(getResultSet.getResultSet().getString("goodName"));
                good.setGoodPrice(getResultSet.getResultSet().getDouble("goodPrice"));
                good.setGoodRigin(getResultSet.getResultSet().getString("goodRigin"));
                good.setProductData(getResultSet.getResultSet().getString("productData"));
                good.setMonthNumber(getResultSet.getResultSet().getInt("monthNumber"));
                good.setShelvesDate(getResultSet.getResultSet().getString("shelvesDate"));
                good.setEliminateKey(getResultSet.getResultSet().getInt("eliminateKey"));
                good.setEliminateDate(getResultSet.getResultSet().getString("eliminateDate"));
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

    /**
     * 查看是否有该商品
     * @param goodID
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * 通过商品ID获取商品信息
     * @param goodID
     * @return ReturnInformation
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
