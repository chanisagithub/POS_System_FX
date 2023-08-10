package dao.custom.impl;

import dao.custom.ItemDAO;
import entity.Item;
import dao.CrudUtil;
import java.sql.SQLException;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean save(Item item){
        try{
            return CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?,?,?,?)",
            item.getItemID(),
            item.getItemName(),
            item.getBatchNumber(),
            item.getPrice(),
            item.getQty(),
            item.getSupplier(),
            item.getExpireDate()
        );
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
