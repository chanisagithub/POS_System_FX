package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerID;
    private String firstName;
    private String lastName;
    private String nic;
    private String address;
    private String contactNumber;
}
