package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String nic;
    private String address;
    private String contactNumber;
}
