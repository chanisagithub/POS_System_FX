package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemBoImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean saveItem(ItemDTO itemDTO){
        //Creating item Entity
        Item item=new Item(
                itemDTO.getItemID(),
                itemDTO.getItemName(),
                itemDTO.getBatchNumber(),
                itemDTO.getPrice(),
                itemDTO.getQty(),
                itemDTO.getSupplier(),
                itemDTO.getExpireDate()

        );
        return itemDAO.save(item);
    }

    @Override
    public String getNextID(){
        String lastItemId = itemDAO.getLastItemId();
        int lastId = Integer.parseInt(lastItemId.substring(1));
        return String.format("I%03d",++lastId);
    }
    @Override
    public ObservableList<ItemDTO> getAllItems(){
        ArrayList<Item> allItems = itemDAO.getAllItems();
        ObservableList<ItemDTO> allItemsForTable = FXCollections.observableArrayList();
        for (Item a : allItems){
            allItemsForTable.add(new ItemDTO(
                a.getItemID(),
                a.getItemName(),
                a.getBatchNumber(),
                a.getPrice(),
                a.getQty(),
                a.getSupplier(),
                a.getExpireDate()
            ));
        }
        return allItemsForTable;
    }

    @Override
    public ItemDTO getItemByID(String itemID){
        Item itemById = itemDAO.getItemById(itemID)
            if (itemById != null){
                return new ItemDTO(
                        itemById.getItemID(),
                        itemById.getItemName(),
                        itemById.getBatchNumber(),
                        itemById.getPrice(),
                        itemById.getQty(),
                        itemById.getSupplier(),
                        itemById.getExpireDate()
                );
            }
            return null;
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO){
        return itemDAO.updateItem(new Item(
                itemDTO.getItemID(),
                itemDTO.getItemName(),
                itemDTO.getBatchNumber(),
                itemDTO.getPrice(),
                itemDTO.getQty(),
                itemDTO.getSupplier(),
                itemDTO.getExpireDate()
        ));
    }

    @Override
    public HashMap<String,String> getItemNamesAndIDs(){
        return itemDAO.getItemNames();
    }
}
