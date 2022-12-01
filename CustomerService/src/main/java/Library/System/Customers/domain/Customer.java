package Library.System.Customers.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Customer {
    @Id
    private long customerNumber;
    private String name;
    private Address address;
    private Contact contact;



}
