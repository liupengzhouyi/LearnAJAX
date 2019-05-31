package experiment_9And10.experiment10.good.dao.Interface;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;

import java.sql.SQLException;
import java.util.List;

public interface OperationGood {

    //增加商品
    public ReturnInformation addGood(Good good) throws SQLException, ClassNotFoundException;

    //修改商品信息
    public ReturnInformation resetGood(Good newGood);

    //修改价格
    public ReturnInformation resetGoodPrice(String goodID, String newPrice);

    //下架商品
    public ReturnInformation eliminateGood(String goodID);

    //查找所有商品
    public ReturnInformation findAllGood();

    //查找所有下架商品
    public ReturnInformation findAllEliminateGood();

    //查找所有没有下架商品
    public ReturnInformation findAllNotEliminateGood() throws SQLException, ClassNotFoundException;
}
