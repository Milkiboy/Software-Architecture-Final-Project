package Library.System.Borrowings.service.dtos;

import Library.System.Borrowings.domain.Book;
import Library.System.Borrowings.domain.Customer;
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
public class BorrowingsDto {
    @Id
    private long borrowingNumber;
    private String date;
    private Customer customer;
    private Book book;
}
