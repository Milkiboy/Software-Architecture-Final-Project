package Library.System.Borrowings.domain;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Customer {

    private long customerNumber;
    private String customerName;
}
