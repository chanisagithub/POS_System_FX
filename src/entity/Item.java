package entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Item {
    private String itemID;
    private String itemName;
    private String batchNumber;
    private double price;
    private double qty;
    private String supplier;
    private Date expireDate;
}
