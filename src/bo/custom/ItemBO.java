package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;
import javafx.collections.ObservableList;

import java.util.HashMap;

public interface ItemBO extends SuperBO {
    public boolean saveItem(ItemDTO itemDto);

    public String getNextID();

    public ObservableList<ItemDTO> getAllItems();

    public ItemDTO getItemByID(String itemID);

    public boolean updateItem(ItemDTO itemDTO);

    public HashMap<String,String> getItemNamesAndIDs();

}
