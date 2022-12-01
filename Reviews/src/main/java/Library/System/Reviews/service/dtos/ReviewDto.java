package Library.System.Reviews.service.dtos;

import Library.System.Reviews.domain.Book;
import Library.System.Reviews.domain.Customer;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class ReviewDto {
    @Id
    private long reviewId;

    private Book book;
    private String reviewRating;
    private Customer customer;
    private String description;
}
