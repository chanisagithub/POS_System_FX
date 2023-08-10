package bo.custom;

import bo.SuperBO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    public boolean checkPassword(String username, String password) throws SQLException, ClassNotFoundException;
    public String getUserFullName(String username) throws ClassNotFoundException;
}
