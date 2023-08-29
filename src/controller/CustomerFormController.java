package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CustomerFormController {
    public TextField txtCustID;
    public TextField txtContact;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtAddress;
    public TextField txtNic;
    public Button btnClear;
    public TableView tblCustomer;
    public TableColumn colCustID;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;
    public Button btnAdd;
    public Button btnDelete;
    public Button btnEdit;

    private int selectedIndex = -1;

    private ObservableList<CustomerDTO> allItems;

    private CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.CUSTOMER);

    public void initialize(){
        txtCustID.setText(customerBO.generateNextCustomerID());
    }

    public void clearData(){
        txtFirstName.clear();
        txtLastName.clear();
        txtNic.clear();
        txtContact.clear();
        txtAddress.clear();
    }

    public void setDataToTable(){
        allItems = customerBO;
        tblCustomer.setItems();

    }

    public boolean emptyValidation(){
        return !txtAddress.getText().isEmpty() &&
                !txtContact.getText().isEmpty() &&
                !txtCustID.getText().isEmpty() &&
                !txtFirstName.getText().isEmpty() &&
                !txtLastName.getText().isEmpty() &&
                !txtNic.getText().isEmpty();
    }

    private void loadCustomerDataToTable(CustomerDTO selectedCustomer){
        CustomerDTO selectedCustomerDetails = customerBO.
    }
    public void btnAddOnAction(ActionEvent actionEvent) {
        //validating Entries
        if (emptyValidation()){
            boolean saveResult= customerBO.saveCustomer(new CustomerDTO(
                    txtCustID.getText(),
                    txtFirstName.getText(),
                    txtLastName.getText(),
                    txtNic.getText(),
                    txtAddress.getText(),
                    txtContact.getText()
            ));

            Alert alert;
            if(saveResult){
                alert = new Alert(Alert.AlertType.INFORMATION,"Customer successfully saved !");
            }else{
                alert= new Alert(Alert.AlertType.WARNING,"Customer failed to save !");
            }
            alert.show();
            initialize();
            clearData();

        }else {
            new Alert(Alert.AlertType.ERROR,"Please fill all data !").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtCustID.clear();
        txtFirstName.clear();
        txtLastName.clear();
        txtContact.clear();
        txtAddress.clear();
        txtNic.clear();
    }
}
