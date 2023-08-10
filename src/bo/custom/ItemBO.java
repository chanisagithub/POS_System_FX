package bo.custom;

import bo.SuperBO;

public interface ItemBO extends SuperBO {
    public boolean saveItem(ItemDTO itemDto);
}
