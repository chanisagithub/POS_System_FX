package controller;

import bo.BOFactory;
import bo.custom.ItemBO;
import dto.ItemDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    public Button btnDelete;
    public Button btnEdit;

    private int selectedIndex = -1;
    private ObservableList<ItemDTO> allItems;
    ItemBO itemBo = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.ITEM);
    private boolean isEdit=false;

    public void initialize(){
        generateAndSetNextId();

        colItemID.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        colBatchNo.setCellValueFactory(new PropertyValueFactory<>("batchNumber"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colExpireDate.setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        colSupplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));

        setDataToTable();

        tblItems.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) ->{
            selectedIndex = (int) newValue;
        });

    }

    private void loadItemDataToFields(ItemDTO selectedItem){
        ItemDTO selectedItemDetails = itemBo.getItemByID(selectedItem.getItemID());
        txtSupplier.setText(selectedItemDetails.getSupplier());
        txtBatchNumber.setText(selectedItemDetails.getBatchNumber());
        txtItemId.setText(selectedItemDetails.getItemID());
        txtItemPrice.setText(String.format("%.2f",selectedItemDetails.getPrice()));
        pickerExpireDate.getEditor().setText(String.valueOf(selectedItemDetails.getExpireDate()));
        txtItemName.setText(selectedItemDetails.getItemName());
        txtQty.setText(String.format("%.2f",selectedItemDetails.getQty()));
    }


    public void generateAndSetNextId(){
        txtItemId.setText(itemBo.getNextID());
    }

    public void setDataToTable(){
        allItems = itemBo.getAllItems();
        tblItems.setItems(allItems);
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
                
                clearField();
                generateAndSetNextId();
                setDataToTable();


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
                    //setDataToTable();
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



    public void btnDelete(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        if(selectedIndex != -1){
            loadItemDataToFields(allItems.get(selectedIndex));
            btnAdd.setText("Update");
            btnAdd.setStyle("-fx-background-color: #f1c40f");
            isEdit=true;
        }else{
            Alert alert= new Alert(Alert.AlertType.ERROR,"Please select item first");
            alert.show();
        }
    }

}
