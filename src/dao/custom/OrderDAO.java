package dao.custom;

import dao.SuperDAO;

public interface OrderDAO extends SuperDAO {
    public String getLastOrderID();
}
