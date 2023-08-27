package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import dto.ItemDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.Date;
import java.sql.SQLOutput;
import java.time.LocalDate;

public class AddItemController {
    public TextField txtItemId;
    public TextField txtItemName;
    public TextField txtBatchNumber;
    public TextField txtItemPrice;
    public TextField txtSupplier;
    public TableView tblItems;
    public TableColumn colItemID;
    public TableColumn colItemName;
    public TableColumn colBatchNo;
    public TableColumn colItemPrice;
    public TableColumn colSupplier;
    public TableColumn colExpireDate;
    public TextField txtQty;
    public DatePicker pickerExpireDate;
    public Button btnAdd;
    public Button btnCancel;
    public Button btnUpdate;
    public Button btnDelete;

    private int selectedIndex = -1;
    private ObservableList<ItemDTO> allItems;
    ItemBO itemBo = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.ITEM);
    private boolean isEdit=false;

    public void initialize(){

    }


    public void btnAddItem(ActionEvent actionEvent) {
        if (!isEdit){
            ItemDTO itemDTO = new ItemDTO(
                    txtItemId.getText(),
                    txtItemName.getText(),
                    txtBatchNumber.getText(),
                    Double.parseDouble( txtItemPrice.getText()),
                    Double.parseDouble(txtQty.getText()),
                    txtSupplier.getText(),
                    Date.valueOf(LocalDate.now())
            );

            boolean b = itemBo.saveItem(itemDTO);

            if (b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Item Saved");
                alert.show();


            }else{
                boolean updateResult = itemBo.updateItem(new ItemDTO(
                        txtItemId.getText(),
                        txtItemName.getText(),
                        txtBatchNumber.getText(),
                        Double.parseDouble(txtItemPrice.getText()),
                        Double.parseDouble(txtQty.getText()),
                        txtSupplier.getText(),
                        Date.valueOf(LocalDate.now())
                ));

                if(updateResult){
                    Alert alert= new Alert(Alert.AlertType.INFORMATION,"Successfully Updated");
                    alert.show();
                    clearField();
                    initialize();

                    btnAdd.setText("Add");
                    btnAdd.setStyle("-fx-background-color: #1abc9c");
                    isEdit = false;

                }else{
                    System.out.println("Not Updated");
                }
            }
        }
    }

    public void clearField(){
        txtItemId.clear();
        txtItemName.clear();
        txtItemPrice.clear();
        txtBatchNumber.clear();
        txtSupplier.clear();
        txtQty.clear();
        pickerExpireDate.getEditor().clear();
    }

    

    public void btnCancel(ActionEvent actionEvent) {
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }
}
