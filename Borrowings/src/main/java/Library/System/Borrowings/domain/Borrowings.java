package Library.System.Borrowings.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Borrowings {
    @Id
    private long borrowingNumber;
    private String date;
    private Customer customer;
    private Book book;
}
