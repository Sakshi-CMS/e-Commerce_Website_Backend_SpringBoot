package Harsh.Singh.CustomerService.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    private String customerName;
    private long phoneNo;
    private String address;
}
