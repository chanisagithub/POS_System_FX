package dao.custom;

import dao.SuperDAO;

import java.sql.SQLException;

public interface LoginDAO extends SuperDAO {
    public String getPasswordByUsername(String username);
    public String getUserFullName(String username);
}
