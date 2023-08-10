package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.LoginDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public String getPasswordByUsername(String username) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM USERS WHERE username=?", username);
        if (resultSet.next()) {
            return resultSet.getString("password");
        }
        return null;
    }


    @Override
    public String getUserFullName(String username) throws ClassNotFoundException {
        try{
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM users WHERE username=?",username);
            if (resultSet.next()){
                return resultSet.getString("fullName");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}