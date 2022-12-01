package Library.System.Borrowings.service.dtos;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class CustomerDto {
    private long customerNumber;
    private String name;
}
