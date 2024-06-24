package Harsh.Singh.VehicleInfo.Domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String userName;
    private String title;
}
