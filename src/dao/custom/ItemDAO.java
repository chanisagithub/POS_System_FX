package dao.custom;

import dao.SuperDAO;
import entity.Item;

import java.util.ArrayList;
import java.util.HashMap;

public interface ItemDAO  extends SuperDAO {
    public boolean save(Item item);

    public String getLastItemId();

    public ArrayList<Item> getAllItems();

    public Item getItemById(String itemID);

    public boolean updateItem(Item item);

    public HashMap<String, String> getItemNames();
}
