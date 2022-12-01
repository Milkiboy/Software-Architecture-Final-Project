package Library.System.Reviews.domain;

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
public class Review {
    @Id
    private long reviewId;
    private Book book;
    private String reviewRating;
    private Customer customer;
    private String description;


    }

