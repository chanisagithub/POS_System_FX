package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer(
                customerDTO.getCustomerID(),
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getNic(),
                customerDTO.getAddress(),
                customerDTO.getContactNumber()
        );
        return customerDAO.saveCustomer(customer);
    }

    @Override
    public String generateNextCustomerID(){
        String lastItemId = customerDAO.getLastCustomerID();
        int lastId = Integer.parseInt(lastItemId.substring(1));
        return String.format("C%03d",++lastId);
    }

    @Override
    public CustomerDTO getCustomerByContactNumber(String contactNumber){
        Customer ccn = customerDAO.findCustomerByContactNumber(contactNumber);
        return new CustomerDTO(
                ccn.getCustomerID(),
                ccn.getFirstName(),
                ccn.getLastName(),
                ccn.getNic(),
                ccn.getAddress(),
                ccn.getContactNumber()
        );
    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomers(){
        ArrayList<Customer> allCustomers= customerDAO.getAllCustomers();
        ObservableList<CustomerDTO> allCustomerForTable = FXCollections.observableArrayList();
        for (Customer c :allCustomers){
            allCustomerForTable.add(new CustomerDTO(
                    c.getCustomerID(),
                    c.getFirstName(),
                    c.getLastName(),
                    c.getNic(),
                    c.getAddress(),
                    c.getContactNumber()

            ));
        }
        return allCustomerForTable;
    }

}
