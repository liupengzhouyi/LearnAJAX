package experiment_9And10.experiment10.good.dao.Interface;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;

import java.util.List;

public interface operationGood {

    //增加商品
    public ReturnInformation addGood(Good good);

    //修改商品信息
    public ReturnInformation resetGood(Good newGood);

    //修改价格
    public ReturnInformation resetGoodPrice(String goodID, String newPrice);

    //下架商品
    public ReturnInformation eliminateGood(String goodID);

    //查找所有商品
    public List<Good> findAllGood();

    //查找所有下架商品
    public List<Good> findAllEliminateGood();

    //查找所有没有下架商品
    public List<Good> findAllNotEliminateGood();
}
