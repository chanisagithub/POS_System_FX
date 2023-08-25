package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;

public interface CustomerBO extends SuperBO {
    public boolean saveCustomer(CustomerDTO customerDTO);

    public String generateNextCustomerID();

    public CustomerDTO getCustomerByContactNumber(String contactNumber);
}
