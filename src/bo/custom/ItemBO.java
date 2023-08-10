package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;

public interface ItemBO extends SuperBO {
    public boolean saveItem(ItemDTO itemDto);
}
