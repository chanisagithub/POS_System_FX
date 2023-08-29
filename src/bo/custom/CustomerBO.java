package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface CustomerBO extends SuperBO {
    public boolean saveCustomer(CustomerDTO customerDTO);

    public String generateNextCustomerID();

    public CustomerDTO getCustomerByContactNumber(String contactNumber);

    public ObservableList<CustomerDTO> getAllCustomers();
}
