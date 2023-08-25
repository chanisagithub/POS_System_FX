package dao.custom;

import dao.SuperDAO;
import entity.Customer;

public interface CustomerDAO extends SuperDAO {
    public boolean saveCustomer(Customer customer);

    public String getLastCustomerID();

    public Customer findCustomerByContactNumber(String contactNumber);
}
