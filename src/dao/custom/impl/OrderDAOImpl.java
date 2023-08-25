package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String getLastOrderID(){
        try {
            ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM orders ORDER BY orderID DESC LIMIT 1");
            if (resultSet.next()){
                return resultSet.getString("orderID");

            }
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return "0000";
    }
}
