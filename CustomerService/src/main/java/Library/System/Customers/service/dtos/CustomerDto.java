package Library.System.Customers.service.dtos;



import Library.System.Customers.domain.Address;
import Library.System.Customers.domain.Contact;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CustomerDto {
    private long customerNumber;
    private String name;
    private Address address;
    private Contact contact;
}
