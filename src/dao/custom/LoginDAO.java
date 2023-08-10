package dao.custom;

import dao.SuperDAO;

import java.sql.SQLException;

public interface LoginDAO extends SuperDAO {
    public String getPasswordByUsername(String username) throws SQLException, ClassNotFoundException;
    public String getUserFullName(String username) throws ClassNotFoundException;
}
