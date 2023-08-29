package dto;

import lombok.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class ItemDTO {
    private String itemID;
    private String itemName;
    private String batchNumber;
    private double price;
    private double qty;
    private String supplier;
    private Date expireDate;





}
