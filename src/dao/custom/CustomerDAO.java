package dao.custom;

import dao.SuperDAO;
import entity.Customer;

import java.util.ArrayList;

public interface CustomerDAO extends SuperDAO {
    public boolean saveCustomer(Customer customer);

    public String getLastCustomerID();

    public Customer findCustomerByContactNumber(String contactNumber);

    public ArrayList<Customer> getAllCustomers();
}
